package com.tencent.mobileqq.activity.editservice;

import QQService.EVIPSPEC;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.LayoutManager;
import android.text.Editable;
import android.text.InputFilter;
import android.text.Selection;
import android.text.Spannable;
import android.text.SpannableString;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.activity.PublicFragmentActivity.Launcher;
import com.tencent.mobileqq.apollo.handler.IApolloExtensionHandler;
import com.tencent.mobileqq.apollo.handler.IApolloExtensionObserver;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.SVIPHandler;
import com.tencent.mobileqq.app.SVIPObserver;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.data.troop.TroopMemberCardInfo;
import com.tencent.mobileqq.emoticonview.EmoticonCallback;
import com.tencent.mobileqq.emoticonview.EmoticonInfo;
import com.tencent.mobileqq.emoticonview.IEmoticonMainPanel;
import com.tencent.mobileqq.emoticonview.ISmallEmoticonInfo;
import com.tencent.mobileqq.emoticonview.SystemAndEmojiEmoticonInfo;
import com.tencent.mobileqq.emoticonview.api.IEmoticonMainPanelService;
import com.tencent.mobileqq.emoticonview.api.IEmoticonMainPanelService.PanelBuilder;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.profile.view.SoftInputDetectView;
import com.tencent.mobileqq.profile.view.SoftInputDetectView.OnImStateChangedListener;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.text.ColorNickText;
import com.tencent.mobileqq.text.NickColorEmoticonBuilder;
import com.tencent.mobileqq.text.QQText;
import com.tencent.mobileqq.troop.activity.PresetWordsListAdapter;
import com.tencent.mobileqq.troop.activity.TroopNickRuleFragment;
import com.tencent.mobileqq.troop.activity.editinfo.IEditInfoActivity;
import com.tencent.mobileqq.troop.activity.editinfo.IEditInfoApi;
import com.tencent.mobileqq.troop.api.ITroopInfoService;
import com.tencent.mobileqq.troop.api.handler.ITroopMemberCardHandler;
import com.tencent.mobileqq.troop.api.handler.ITroopMemberInfoHandler;
import com.tencent.mobileqq.troop.api.observer.TroopObserver;
import com.tencent.mobileqq.troop.widget.PresetWordFlowLayout;
import com.tencent.mobileqq.util.DisplayUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.vas.ColorNickColorPanelAdapter;
import com.tencent.mobileqq.vas.ColorNickColorPanelAdapter.ColorItem;
import com.tencent.mobileqq.vas.ColorNickColorPanelAdapter.EndlessRecyclerOnScrollListener;
import com.tencent.mobileqq.vas.ColorNickColorPanelAdapter.OnColorSelectListener;
import com.tencent.mobileqq.vas.ColorNickManager;
import com.tencent.mobileqq.vas.ColorNickManager.ColorNickEmoticonListProvider;
import com.tencent.mobileqq.vas.VasH5PayUtil;
import com.tencent.mobileqq.vas.config.business.qvip.QVipColorNickConfig;
import com.tencent.mobileqq.vas.config.business.qvip.QVipColorNickProcessor;
import com.tencent.mobileqq.vas.config.business.qvip.QVipTroopNickConfig;
import com.tencent.mobileqq.vas.config.business.qvip.QVipTroopNickProcessor;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.mobileqq.vas.troopnick.shop.adapter.AuthRequest.AuthListener;
import com.tencent.mobileqq.vas.troopnick.shop.adapter.TroopNickAuthRequest;
import com.tencent.mobileqq.vas.troopnick.shop.adapter.TroopNickRequest;
import com.tencent.mobileqq.vas.troopnick.shop.widget.ShopAdapter;
import com.tencent.mobileqq.vas.troopnick.shop.widget.ShopLayout;
import com.tencent.mobileqq.vas.webview.util.VasWebviewUtil;
import com.tencent.mobileqq.widget.ClearableEditText.OnTextClearedListener;
import com.tencent.mobileqq.widget.ColorClearableEditText;
import com.tencent.mobileqq.widget.ColorClearableEditText.Paragraph;
import com.tencent.mobileqq.widget.ColorNickTextView;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.widget.navbar.OnItemSelectListener;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import tencent.im.oidb.cmd0x8fc.Oidb_0x8fc.CommCardNameBuf;
import tencent.im.oidb.cmd0x8fc.Oidb_0x8fc.RichCardNameElem;

public class EditTroopMemberNickService
  implements Handler.Callback, View.OnClickListener, EmoticonCallback, IEditInfoApi
{
  protected int a;
  private Context jdField_a_of_type_AndroidContentContext;
  protected Handler a;
  RecyclerView.LayoutManager jdField_a_of_type_AndroidSupportV7WidgetRecyclerView$LayoutManager;
  RecyclerView jdField_a_of_type_AndroidSupportV7WidgetRecyclerView;
  private View jdField_a_of_type_AndroidViewView;
  protected EditText a;
  ImageView jdField_a_of_type_AndroidWidgetImageView;
  LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  TextView jdField_a_of_type_AndroidWidgetTextView = null;
  private final IApolloExtensionObserver jdField_a_of_type_ComTencentMobileqqApolloHandlerIApolloExtensionObserver = new EditTroopMemberNickService.12(this);
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private final SVIPObserver jdField_a_of_type_ComTencentMobileqqAppSVIPObserver = new EditTroopMemberNickService.11(this);
  IEmoticonMainPanel jdField_a_of_type_ComTencentMobileqqEmoticonviewIEmoticonMainPanel;
  SoftInputDetectView.OnImStateChangedListener jdField_a_of_type_ComTencentMobileqqProfileViewSoftInputDetectView$OnImStateChangedListener = new EditTroopMemberNickService.9(this);
  SoftInputDetectView jdField_a_of_type_ComTencentMobileqqProfileViewSoftInputDetectView;
  protected PresetWordsListAdapter a;
  private IEditInfoActivity jdField_a_of_type_ComTencentMobileqqTroopActivityEditinfoIEditInfoActivity;
  TroopObserver jdField_a_of_type_ComTencentMobileqqTroopApiObserverTroopObserver = new EditTroopMemberNickService.7(this);
  PresetWordFlowLayout jdField_a_of_type_ComTencentMobileqqTroopWidgetPresetWordFlowLayout;
  private final ColorNickColorPanelAdapter.EndlessRecyclerOnScrollListener jdField_a_of_type_ComTencentMobileqqVasColorNickColorPanelAdapter$EndlessRecyclerOnScrollListener = new EditTroopMemberNickService.13(this);
  ColorNickColorPanelAdapter.OnColorSelectListener jdField_a_of_type_ComTencentMobileqqVasColorNickColorPanelAdapter$OnColorSelectListener = new EditTroopMemberNickService.8(this);
  ColorNickColorPanelAdapter jdField_a_of_type_ComTencentMobileqqVasColorNickColorPanelAdapter;
  ShopLayout jdField_a_of_type_ComTencentMobileqqVasTroopnickShopWidgetShopLayout;
  ClearableEditText.OnTextClearedListener jdField_a_of_type_ComTencentMobileqqWidgetClearableEditText$OnTextClearedListener = new EditTroopMemberNickService.10(this);
  ColorNickTextView jdField_a_of_type_ComTencentMobileqqWidgetColorNickTextView;
  protected String a;
  protected ArrayList<String> a;
  protected boolean a;
  private ColorNickColorPanelAdapter.ColorItem[] jdField_a_of_type_ArrayOfComTencentMobileqqVasColorNickColorPanelAdapter$ColorItem = { new ColorNickColorPanelAdapter.ColorItem(2, null, 0, null) };
  protected int b;
  ImageView jdField_b_of_type_AndroidWidgetImageView;
  RelativeLayout jdField_b_of_type_AndroidWidgetRelativeLayout;
  TextView jdField_b_of_type_AndroidWidgetTextView;
  protected String b;
  private ArrayList<ColorNickColorPanelAdapter.ColorItem> jdField_b_of_type_JavaUtilArrayList = new ArrayList();
  protected boolean b;
  protected int c;
  ImageView jdField_c_of_type_AndroidWidgetImageView;
  RelativeLayout jdField_c_of_type_AndroidWidgetRelativeLayout;
  TextView jdField_c_of_type_AndroidWidgetTextView;
  String jdField_c_of_type_JavaLangString;
  private ArrayList<Integer> jdField_c_of_type_JavaUtilArrayList = new ArrayList();
  boolean jdField_c_of_type_Boolean;
  int jdField_d_of_type_Int = 0;
  ImageView jdField_d_of_type_AndroidWidgetImageView;
  RelativeLayout jdField_d_of_type_AndroidWidgetRelativeLayout;
  TextView jdField_d_of_type_AndroidWidgetTextView;
  String jdField_d_of_type_JavaLangString;
  private boolean jdField_d_of_type_Boolean = false;
  private int jdField_e_of_type_Int = 0;
  TextView jdField_e_of_type_AndroidWidgetTextView;
  protected String e;
  private boolean jdField_e_of_type_Boolean = false;
  private int f = 0;
  private int g = 0;
  
  public EditTroopMemberNickService()
  {
    this.jdField_a_of_type_AndroidWidgetEditText = null;
    this.jdField_a_of_type_Boolean = false;
    this.jdField_b_of_type_Boolean = false;
    this.jdField_a_of_type_Int = -1;
    this.jdField_a_of_type_JavaLangString = null;
    this.jdField_b_of_type_JavaLangString = null;
    this.jdField_b_of_type_Int = 0;
    this.jdField_c_of_type_Int = -1;
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_a_of_type_AndroidOsHandler = new Handler(this);
  }
  
  private Resources a()
  {
    return this.jdField_a_of_type_AndroidContentContext.getResources();
  }
  
  private <T extends View> T a(int paramInt)
  {
    View localView = this.jdField_a_of_type_AndroidViewView;
    if (localView != null) {
      return localView.findViewById(paramInt);
    }
    return null;
  }
  
  private String a(int paramInt)
  {
    return HardCodeUtil.a(paramInt);
  }
  
  private boolean a()
  {
    return this.jdField_d_of_type_JavaLangString.equals(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
  }
  
  /* Error */
  private boolean a(EditTroopMemberNickService.NickInfo paramNickInfo)
  {
    // Byte code:
    //   0: aload_1
    //   1: ifnull +18 -> 19
    //   4: aload_1
    //   5: iconst_0
    //   6: putfield 219	com/tencent/mobileqq/activity/editservice/EditTroopMemberNickService$NickInfo:jdField_b_of_type_Boolean	Z
    //   9: aload_1
    //   10: iconst_0
    //   11: putfield 220	com/tencent/mobileqq/activity/editservice/EditTroopMemberNickService$NickInfo:jdField_a_of_type_Boolean	Z
    //   14: aload_1
    //   15: iconst_0
    //   16: putfield 222	com/tencent/mobileqq/activity/editservice/EditTroopMemberNickService$NickInfo:jdField_c_of_type_Boolean	Z
    //   19: aload_0
    //   20: getfield 59	com/tencent/mobileqq/activity/editservice/EditTroopMemberNickService:jdField_a_of_type_AndroidWidgetEditText	Landroid/widget/EditText;
    //   23: astore 7
    //   25: aload 7
    //   27: instanceof 224
    //   30: ifeq +249 -> 279
    //   33: aload 7
    //   35: checkcast 224	com/tencent/mobileqq/widget/ColorClearableEditText
    //   38: astore 7
    //   40: aload 7
    //   42: invokevirtual 226	com/tencent/mobileqq/widget/ColorClearableEditText:a	()I
    //   45: ifle +14 -> 59
    //   48: aload_1
    //   49: ifnull +10 -> 59
    //   52: aload_1
    //   53: iconst_1
    //   54: putfield 222	com/tencent/mobileqq/activity/editservice/EditTroopMemberNickService$NickInfo:jdField_c_of_type_Boolean	Z
    //   57: iconst_1
    //   58: ireturn
    //   59: aload 7
    //   61: invokevirtual 228	com/tencent/mobileqq/widget/ColorClearableEditText:a	()V
    //   64: aload 7
    //   66: invokevirtual 231	com/tencent/mobileqq/widget/ColorClearableEditText:a	()Ljava/util/ArrayList;
    //   69: astore 7
    //   71: aload 7
    //   73: ifnull +206 -> 279
    //   76: aload 7
    //   78: invokevirtual 234	java/util/ArrayList:size	()I
    //   81: ifle +198 -> 279
    //   84: aload 7
    //   86: invokevirtual 238	java/util/ArrayList:iterator	()Ljava/util/Iterator;
    //   89: astore 7
    //   91: iconst_0
    //   92: istore 4
    //   94: iconst_0
    //   95: istore_3
    //   96: aload 7
    //   98: invokeinterface 243 1 0
    //   103: ifeq +129 -> 232
    //   106: aload 7
    //   108: invokeinterface 247 1 0
    //   113: checkcast 249	com/tencent/mobileqq/widget/ColorClearableEditText$Paragraph
    //   116: astore 8
    //   118: aload 8
    //   120: getfield 250	com/tencent/mobileqq/widget/ColorClearableEditText$Paragraph:jdField_c_of_type_Int	I
    //   123: iconst_1
    //   124: if_icmpne +13 -> 137
    //   127: iconst_1
    //   128: istore 6
    //   130: iload 4
    //   132: istore 5
    //   134: goto +56 -> 190
    //   137: aload 8
    //   139: getfield 250	com/tencent/mobileqq/widget/ColorClearableEditText$Paragraph:jdField_c_of_type_Int	I
    //   142: iconst_3
    //   143: if_icmpne +12 -> 155
    //   146: iconst_1
    //   147: istore 5
    //   149: iload_3
    //   150: istore 6
    //   152: goto +38 -> 190
    //   155: aload 8
    //   157: getfield 250	com/tencent/mobileqq/widget/ColorClearableEditText$Paragraph:jdField_c_of_type_Int	I
    //   160: istore_2
    //   161: iload 4
    //   163: istore 5
    //   165: iload_3
    //   166: istore 6
    //   168: iload_2
    //   169: iconst_2
    //   170: if_icmpne +20 -> 190
    //   173: aload_1
    //   174: ifnull +14 -> 188
    //   177: aload_1
    //   178: iload 4
    //   180: putfield 219	com/tencent/mobileqq/activity/editservice/EditTroopMemberNickService$NickInfo:jdField_b_of_type_Boolean	Z
    //   183: aload_1
    //   184: iload_3
    //   185: putfield 220	com/tencent/mobileqq/activity/editservice/EditTroopMemberNickService$NickInfo:jdField_a_of_type_Boolean	Z
    //   188: iconst_1
    //   189: ireturn
    //   190: iload 5
    //   192: istore 4
    //   194: iload 6
    //   196: istore_3
    //   197: iload 5
    //   199: ifeq -103 -> 96
    //   202: iload 5
    //   204: istore 4
    //   206: iload 6
    //   208: istore_3
    //   209: iload 6
    //   211: ifeq -115 -> 96
    //   214: aload_1
    //   215: ifnull +15 -> 230
    //   218: aload_1
    //   219: iload 5
    //   221: putfield 219	com/tencent/mobileqq/activity/editservice/EditTroopMemberNickService$NickInfo:jdField_b_of_type_Boolean	Z
    //   224: aload_1
    //   225: iload 6
    //   227: putfield 220	com/tencent/mobileqq/activity/editservice/EditTroopMemberNickService$NickInfo:jdField_a_of_type_Boolean	Z
    //   230: iconst_1
    //   231: ireturn
    //   232: aload_1
    //   233: ifnull +46 -> 279
    //   236: aload_1
    //   237: iload 4
    //   239: putfield 219	com/tencent/mobileqq/activity/editservice/EditTroopMemberNickService$NickInfo:jdField_b_of_type_Boolean	Z
    //   242: aload_1
    //   243: iload_3
    //   244: putfield 220	com/tencent/mobileqq/activity/editservice/EditTroopMemberNickService$NickInfo:jdField_a_of_type_Boolean	Z
    //   247: iconst_0
    //   248: ireturn
    //   249: astore 7
    //   251: goto +10 -> 261
    //   254: astore 7
    //   256: iconst_0
    //   257: istore 4
    //   259: iconst_0
    //   260: istore_3
    //   261: aload_1
    //   262: ifnull +14 -> 276
    //   265: aload_1
    //   266: iload 4
    //   268: putfield 219	com/tencent/mobileqq/activity/editservice/EditTroopMemberNickService$NickInfo:jdField_b_of_type_Boolean	Z
    //   271: aload_1
    //   272: iload_3
    //   273: putfield 220	com/tencent/mobileqq/activity/editservice/EditTroopMemberNickService$NickInfo:jdField_a_of_type_Boolean	Z
    //   276: aload 7
    //   278: athrow
    //   279: iconst_0
    //   280: ireturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	281	0	this	EditTroopMemberNickService
    //   0	281	1	paramNickInfo	EditTroopMemberNickService.NickInfo
    //   160	11	2	i	int
    //   95	178	3	bool1	boolean
    //   92	175	4	bool2	boolean
    //   132	88	5	bool3	boolean
    //   128	98	6	bool4	boolean
    //   23	84	7	localObject1	Object
    //   249	1	7	localObject2	Object
    //   254	23	7	localObject3	Object
    //   116	40	8	localParagraph	ColorClearableEditText.Paragraph
    // Exception table:
    //   from	to	target	type
    //   96	127	249	finally
    //   137	146	249	finally
    //   155	161	249	finally
    //   84	91	254	finally
  }
  
  private int b()
  {
    Object localObject2;
    if (a(new EditTroopMemberNickService.NickInfo()))
    {
      localObject1 = ((ColorClearableEditText)this.jdField_a_of_type_AndroidWidgetEditText).a();
      ArrayList localArrayList = new ArrayList();
      Iterator localIterator = ((ArrayList)localObject1).iterator();
      while (localIterator.hasNext())
      {
        localObject1 = (ColorClearableEditText.Paragraph)localIterator.next();
        Oidb_0x8fc.RichCardNameElem localRichCardNameElem = new Oidb_0x8fc.RichCardNameElem();
        i = ((ColorClearableEditText.Paragraph)localObject1).jdField_c_of_type_Int;
        if (i != 1)
        {
          if ((i == 2) || (i == 3))
          {
            localObject2 = ((ColorClearableEditText.Paragraph)localObject1).jdField_a_of_type_JavaLangString;
            localObject1 = localObject2;
            if (((String)localObject2).substring(0, 1).equals("<")) {
              localObject1 = ((String)localObject2).substring(1);
            }
            localObject2 = localObject1;
            if (((String)localObject1).substring(((String)localObject1).length() - 1).equals(">")) {
              localObject2 = ((String)localObject1).substring(0, ((String)localObject1).length() - 1);
            }
            localRichCardNameElem.bytes_ctrl.set(ByteStringMicro.copyFrom(((String)localObject2).getBytes()));
          }
        }
        else {
          localRichCardNameElem.bytes_text.set(ByteStringMicro.copyFrom(this.jdField_a_of_type_AndroidWidgetEditText.getText().toString().getBytes()));
        }
        localArrayList.add(localRichCardNameElem);
      }
      localObject1 = new Oidb_0x8fc.CommCardNameBuf();
      ((Oidb_0x8fc.CommCardNameBuf)localObject1).rpt_rich_card_name.set(localArrayList);
      return ((Oidb_0x8fc.CommCardNameBuf)localObject1).toByteArray().length + 3;
    }
    Object localObject1 = this.jdField_a_of_type_AndroidWidgetEditText.getText();
    if (localObject1 == null) {
      localObject1 = "";
    } else {
      localObject1 = localObject1.toString();
    }
    int i = ((String)localObject1).trim().length();
    try
    {
      int j = ((String)localObject1).getBytes("utf-8").length;
      return j;
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
      if (QLog.isColorLevel())
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("UnsupportedEncodingException:");
        ((StringBuilder)localObject2).append(localUnsupportedEncodingException.getMessage());
        QLog.d("ColorNick", 2, ((StringBuilder)localObject2).toString());
      }
    }
    return i;
  }
  
  private void b(int paramInt)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqAppSVIPObserver);
    ((SVIPHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.SVIP_HANDLER)).e(paramInt);
  }
  
  private void b(boolean paramBoolean)
  {
    Object localObject = new ArrayList();
    Collections.addAll((Collection)localObject, this.jdField_a_of_type_ArrayOfComTencentMobileqqVasColorNickColorPanelAdapter$ColorItem);
    ((ArrayList)localObject).addAll(this.jdField_b_of_type_JavaUtilArrayList);
    this.jdField_a_of_type_ComTencentMobileqqVasColorNickColorPanelAdapter.a((List)localObject, paramBoolean);
    localObject = ((FriendsManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER)).e(this.jdField_d_of_type_JavaLangString);
    if (localObject != null)
    {
      if (((Friends)localObject).isServiceEnabled(EVIPSPEC.E_SP_SUPERVIP))
      {
        this.jdField_b_of_type_AndroidWidgetTextView.setText(a(2131690888));
        this.jdField_c_of_type_AndroidWidgetTextView.setText(a(2131690889));
        return;
      }
      this.jdField_b_of_type_AndroidWidgetTextView.setText(a(2131690886));
      this.jdField_c_of_type_AndroidWidgetTextView.setText(a(2131690887));
    }
  }
  
  private boolean b()
  {
    QVipColorNickConfig localQVipColorNickConfig = QVipColorNickProcessor.c();
    if (localQVipColorNickConfig == null) {
      return a();
    }
    return (localQVipColorNickConfig.jdField_a_of_type_Boolean) && (a());
  }
  
  private int c()
  {
    return a().getDimensionPixelSize(2131299168);
  }
  
  private void c(int paramInt)
  {
    if (paramInt != 1)
    {
      if (paramInt == 2) {
        if (this.g == 2)
        {
          this.jdField_a_of_type_ComTencentMobileqqTroopActivityEditinfoIEditInfoActivity.showInputMethod();
        }
        else
        {
          this.g = 2;
          this.jdField_d_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
          ColorNickManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).jdField_a_of_type_AndroidOsHandler = this.jdField_a_of_type_AndroidOsHandler;
          this.jdField_b_of_type_AndroidWidgetImageView.setImageResource(2130847302);
          this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130847309);
          this.jdField_b_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
          this.jdField_c_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
          this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setVisibility(0);
          ((RelativeLayout.LayoutParams)this.jdField_b_of_type_AndroidWidgetRelativeLayout.getLayoutParams()).height = DisplayUtil.a(this.jdField_a_of_type_AndroidContentContext, 388.0F);
          ((RelativeLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetRelativeLayout.getLayoutParams()).bottomMargin = DisplayUtil.a(this.jdField_a_of_type_AndroidContentContext, 388.0F);
        }
      }
    }
    else if (this.g == 1)
    {
      this.jdField_a_of_type_ComTencentMobileqqTroopActivityEditinfoIEditInfoActivity.showInputMethod();
    }
    else
    {
      this.g = 1;
      this.jdField_d_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
      ColorNickManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).jdField_a_of_type_AndroidOsHandler = this.jdField_a_of_type_AndroidOsHandler;
      this.jdField_b_of_type_AndroidWidgetImageView.setImageResource(2130847303);
      this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130847308);
      this.jdField_b_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
      this.jdField_c_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
      this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setVisibility(8);
      ((RelativeLayout.LayoutParams)this.jdField_b_of_type_AndroidWidgetRelativeLayout.getLayoutParams()).height = DisplayUtil.a(this.jdField_a_of_type_AndroidContentContext, 387.0F);
      ((RelativeLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetRelativeLayout.getLayoutParams()).bottomMargin = DisplayUtil.a(this.jdField_a_of_type_AndroidContentContext, 387.0F);
      if (this.jdField_a_of_type_ComTencentMobileqqEmoticonviewIEmoticonMainPanel == null)
      {
        IEmoticonMainPanelService.PanelBuilder localPanelBuilder = ((IEmoticonMainPanelService)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(IEmoticonMainPanelService.class)).newBuilder(this.jdField_a_of_type_AndroidContentContext, 100001);
        boolean bool;
        if (this.jdField_c_of_type_Int == 0) {
          bool = true;
        } else {
          bool = false;
        }
        this.jdField_a_of_type_ComTencentMobileqqEmoticonviewIEmoticonMainPanel = localPanelBuilder.setFilterSysFaceBeyond255Enable(bool).setCallBack(this).setDisableGuide(true).setDisableMoreEmotionButton(true).setHasBigEmotion(false).setOnlySysAndEmoji(true).setDisableAutoDownload(true).setToastOffset(c()).setEmoticonListProvider(ColorNickManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).jdField_a_of_type_ComTencentMobileqqVasColorNickManager$ColorNickEmoticonListProvider).create();
        this.jdField_a_of_type_ComTencentMobileqqEmoticonviewIEmoticonMainPanel.setTabListOverScrollMode(2);
        this.jdField_c_of_type_AndroidWidgetRelativeLayout.addView(this.jdField_a_of_type_ComTencentMobileqqEmoticonviewIEmoticonMainPanel.getView());
      }
    }
    this.jdField_e_of_type_Int = 0;
  }
  
  private void i()
  {
    if (QLog.isColorLevel()) {
      QLog.d("EditTroopMemberNickService", 2, "initGetTroopNickRule EditMode isTroopNick");
    }
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)a(2131379321));
    Object localObject = this.jdField_a_of_type_AndroidWidgetLinearLayout;
    if (localObject == null) {
      return;
    }
    ((LinearLayout)localObject).setVerticalScrollBarEnabled(false);
    this.jdField_a_of_type_AndroidWidgetTextView = this.jdField_a_of_type_ComTencentMobileqqTroopActivityEditinfoIEditInfoActivity.getTipsView();
    localObject = this.jdField_a_of_type_AndroidWidgetTextView;
    if (localObject == null) {
      return;
    }
    ((TextView)localObject).setOnClickListener(new EditTroopMemberNickService.1(this));
    this.jdField_e_of_type_AndroidWidgetTextView = ((TextView)a(2131379320));
    this.jdField_d_of_type_AndroidWidgetImageView = ((ImageView)a(2131379318));
    this.jdField_d_of_type_AndroidWidgetImageView.setOnClickListener(new EditTroopMemberNickService.2(this));
    if (ThemeUtil.isInNightMode(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface)) {
      this.jdField_d_of_type_AndroidWidgetImageView.setBackgroundDrawable(a().getDrawable(2130846372));
    }
    this.jdField_a_of_type_ComTencentMobileqqTroopWidgetPresetWordFlowLayout = ((PresetWordFlowLayout)a(2131379322));
    this.jdField_a_of_type_ComTencentMobileqqTroopWidgetPresetWordFlowLayout.jdField_b_of_type_Int = ViewUtils.b(12.0F);
    this.jdField_a_of_type_ComTencentMobileqqTroopWidgetPresetWordFlowLayout.jdField_d_of_type_Int = ViewUtils.b(12.0F);
    this.jdField_a_of_type_ComTencentMobileqqTroopActivityPresetWordsListAdapter = new PresetWordsListAdapter();
    if (ThemeUtil.isInNightMode(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface)) {
      this.jdField_a_of_type_ComTencentMobileqqTroopActivityPresetWordsListAdapter.b();
    }
    this.jdField_a_of_type_ComTencentMobileqqTroopActivityPresetWordsListAdapter.c();
    this.jdField_a_of_type_ComTencentMobileqqTroopActivityPresetWordsListAdapter.a = new EditTroopMemberNickService.3(this);
    this.jdField_a_of_type_ComTencentMobileqqTroopWidgetPresetWordFlowLayout.setAdapter(this.jdField_a_of_type_ComTencentMobileqqTroopActivityPresetWordsListAdapter);
    k();
  }
  
  private void j()
  {
    Object localObject = ((ITroopInfoService)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(ITroopInfoService.class, "")).findTroopInfo(this.jdField_c_of_type_JavaLangString);
    if (localObject != null)
    {
      Intent localIntent = new Intent();
      localIntent.putExtra(TroopNickRuleFragment.jdField_a_of_type_JavaLangString, this.jdField_c_of_type_JavaLangString);
      localIntent.putExtra(TroopNickRuleFragment.jdField_b_of_type_JavaLangString, ((TroopInfo)localObject).groupCardPrefixIntro);
      if (this.jdField_c_of_type_Int == 0) {
        localIntent.putExtra(TroopNickRuleFragment.jdField_d_of_type_JavaLangString, "1");
      } else {
        localIntent.putExtra(TroopNickRuleFragment.jdField_d_of_type_JavaLangString, "3");
      }
      localObject = ((TroopInfo)localObject).getGroupCardPrefix();
      if (localObject != null) {
        localIntent.putStringArrayListExtra(TroopNickRuleFragment.jdField_c_of_type_JavaLangString, (ArrayList)localObject);
      }
      PublicFragmentActivity.Launcher.a(this.jdField_a_of_type_AndroidContentContext, localIntent, PublicFragmentActivity.class, TroopNickRuleFragment.class, 1);
    }
  }
  
  private void k()
  {
    Object localObject1 = ((ITroopInfoService)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(ITroopInfoService.class, "")).findTroopInfo(this.jdField_c_of_type_JavaLangString);
    if (localObject1 != null)
    {
      this.jdField_a_of_type_JavaUtilArrayList = ((TroopInfo)localObject1).getGroupCardPrefix();
      Object localObject2 = this.jdField_a_of_type_ComTencentMobileqqTroopWidgetPresetWordFlowLayout;
      int k = 8;
      int i;
      if (localObject2 != null)
      {
        if (this.jdField_a_of_type_JavaUtilArrayList.isEmpty()) {
          i = 8;
        } else {
          i = 0;
        }
        ((PresetWordFlowLayout)localObject2).setVisibility(i);
        m();
      }
      this.jdField_e_of_type_JavaLangString = ((TroopInfo)localObject1).groupCardPrefixIntro;
      localObject2 = this.jdField_e_of_type_AndroidWidgetTextView;
      if (localObject2 != null)
      {
        if (android.text.TextUtils.isEmpty(this.jdField_e_of_type_JavaLangString)) {
          i = 8;
        } else {
          i = 0;
        }
        ((TextView)localObject2).setVisibility(i);
        this.jdField_e_of_type_AndroidWidgetTextView.setText(this.jdField_e_of_type_JavaLangString);
      }
      if ((this.jdField_a_of_type_JavaUtilArrayList.isEmpty()) && (android.text.TextUtils.isEmpty(this.jdField_e_of_type_JavaLangString))) {
        i = 0;
      } else {
        i = 1;
      }
      localObject2 = this.jdField_a_of_type_AndroidWidgetLinearLayout;
      int j;
      if (localObject2 != null)
      {
        if (i != 0) {
          j = 0;
        } else {
          j = 8;
        }
        ((LinearLayout)localObject2).setVisibility(j);
      }
      boolean bool = ((TroopInfo)localObject1).isOwnerOrAdmin(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
      localObject1 = this.jdField_d_of_type_AndroidWidgetImageView;
      if (localObject1 != null)
      {
        if ((i != 0) && (bool)) {
          j = 0;
        } else {
          j = 8;
        }
        ((ImageView)localObject1).setVisibility(j);
      }
      localObject1 = this.jdField_a_of_type_AndroidWidgetTextView;
      if (localObject1 != null)
      {
        j = k;
        if (i == 0)
        {
          j = k;
          if (bool) {
            j = 0;
          }
        }
        ((TextView)localObject1).setVisibility(j);
      }
    }
  }
  
  private void l()
  {
    SpannableString localSpannableString = new ColorNickText(this.jdField_a_of_type_AndroidWidgetEditText.getText().toString(), 16).a();
    ColorNickManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidWidgetEditText, localSpannableString, this.jdField_b_of_type_Int, true);
  }
  
  private void m()
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqTroopActivityPresetWordsListAdapter;
    if (localObject != null)
    {
      ((PresetWordsListAdapter)localObject).a();
      localObject = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      while (((Iterator)localObject).hasNext())
      {
        String str = (String)((Iterator)localObject).next();
        this.jdField_a_of_type_ComTencentMobileqqTroopActivityPresetWordsListAdapter.a(str);
      }
      localObject = this.jdField_a_of_type_ComTencentMobileqqTroopWidgetPresetWordFlowLayout;
      int i;
      if (this.jdField_a_of_type_ComTencentMobileqqTroopActivityPresetWordsListAdapter.getCount() == 0) {
        i = 8;
      } else {
        i = 0;
      }
      ((PresetWordFlowLayout)localObject).setVisibility(i);
      this.jdField_a_of_type_ComTencentMobileqqTroopActivityPresetWordsListAdapter.notifyDataSetChanged();
    }
  }
  
  private void n()
  {
    Object localObject1 = this.jdField_a_of_type_AndroidWidgetEditText.getText();
    if (localObject1 != null) {
      localObject1 = new QQText(localObject1.toString(), 3);
    } else {
      localObject1 = null;
    }
    if (localObject1 == null) {
      localObject2 = "";
    } else {
      localObject2 = ((QQText)localObject1).toString();
    }
    if (localObject1 == null) {
      localObject1 = "";
    } else {
      localObject1 = ((QQText)localObject1).trim();
    }
    VasWebviewUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin(), "group_nickname", "group_nickname_7", "", 1, 0, 0, "", "", "");
    if (!NetworkUtil.isNetSupport(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getApplicationContext()))
    {
      QQToast.a(this.jdField_a_of_type_AndroidContentContext, 1, 2131694424, 0).b(c());
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "Grp_set", "", "nickname edit", "nickname edit_sub_failure", 0, 0, String.valueOf(this.jdField_c_of_type_JavaLangString), "1", "", "");
      return;
    }
    Object localObject3 = localObject1;
    if (a())
    {
      localObject4 = new EditTroopMemberNickService.NickInfo();
      if (a((EditTroopMemberNickService.NickInfo)localObject4))
      {
        if ((((EditTroopMemberNickService.NickInfo)localObject4).jdField_c_of_type_Boolean) && (this.jdField_a_of_type_AndroidWidgetEditText.getText().length() <= 0))
        {
          QQToast.a(this.jdField_a_of_type_AndroidContentContext, HardCodeUtil.a(2131703782), 0).b(c());
          return;
        }
        this.jdField_a_of_type_ComTencentMobileqqTroopActivityEditinfoIEditInfoActivity.loadingProgress(true);
        i = ((ColorClearableEditText)this.jdField_a_of_type_AndroidWidgetEditText).a();
        if (i > 0)
        {
          localObject1 = new EditTroopMemberNickService.15(this, i);
          new TroopNickAuthRequest().a(50, i, 6, (AuthRequest.AuthListener)localObject1);
          this.jdField_c_of_type_Boolean = true;
          return;
        }
        ((IApolloExtensionHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.APOLLO_EXTENSION_HANDLER)).a(this.jdField_c_of_type_JavaLangString, ((ColorClearableEditText)this.jdField_a_of_type_AndroidWidgetEditText).a(), i);
        this.jdField_c_of_type_Boolean = true;
        return;
      }
      localObject3 = localObject1;
      if (((EditTroopMemberNickService.NickInfo)localObject4).jdField_b_of_type_Boolean)
      {
        localObject3 = localObject1;
        if (!((EditTroopMemberNickService.NickInfo)localObject4).jdField_a_of_type_Boolean) {
          localObject3 = "";
        }
      }
    }
    int i = this.jdField_d_of_type_Int;
    if (((i == 3) || (i == 4)) && (android.text.TextUtils.isEmpty((CharSequence)localObject3)) && (!android.text.TextUtils.isEmpty((CharSequence)localObject2)))
    {
      QQToast.a(this.jdField_a_of_type_AndroidContentContext, a(2131693300), 0).b(c());
      return;
    }
    i = ((ColorClearableEditText)this.jdField_a_of_type_AndroidWidgetEditText).a();
    if (((android.text.TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString)) && (android.text.TextUtils.isEmpty((CharSequence)localObject3))) || ((!android.text.TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString)) && (this.jdField_b_of_type_JavaLangString.equals(localObject3)) && (this.jdField_b_of_type_Int == i)))
    {
      this.jdField_a_of_type_ComTencentMobileqqTroopActivityEditinfoIEditInfoActivity.onFinish();
      return;
    }
    Object localObject2 = new TroopMemberCardInfo();
    ((TroopMemberCardInfo)localObject2).name = ((String)localObject3);
    ((TroopMemberCardInfo)localObject2).memberuin = this.jdField_d_of_type_JavaLangString;
    ((TroopMemberCardInfo)localObject2).troopuin = this.jdField_c_of_type_JavaLangString;
    ((TroopMemberCardInfo)localObject2).email = "";
    ((TroopMemberCardInfo)localObject2).memo = "";
    ((TroopMemberCardInfo)localObject2).sex = -1;
    ((TroopMemberCardInfo)localObject2).tel = "";
    localObject1 = new ArrayList();
    ((ArrayList)localObject1).add(localObject2);
    localObject2 = new ArrayList();
    ((ArrayList)localObject2).add(Integer.valueOf(1));
    localObject3 = (ITroopMemberCardHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.TROOP_MEMBER_CARD_HANDLER);
    if ((localObject3 != null) && (!android.text.TextUtils.isEmpty(this.jdField_c_of_type_JavaLangString)))
    {
      this.jdField_a_of_type_ComTencentMobileqqTroopActivityEditinfoIEditInfoActivity.loadingProgress(true);
      ((ITroopMemberCardHandler)localObject3).a(this.jdField_c_of_type_JavaLangString, (ArrayList)localObject1, (ArrayList)localObject2);
    }
    int j = 2;
    localObject1 = ((ITroopInfoService)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(ITroopInfoService.class, "")).findTroopInfo(this.jdField_c_of_type_JavaLangString);
    i = j;
    if (localObject1 != null) {
      if ((!android.text.TextUtils.isEmpty(((TroopInfo)localObject1).troopowneruin)) && (((TroopInfo)localObject1).troopowneruin.equalsIgnoreCase(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount())))
      {
        i = 0;
      }
      else
      {
        i = j;
        if (!android.text.TextUtils.isEmpty(((TroopInfo)localObject1).Administrator))
        {
          i = j;
          if (((TroopInfo)localObject1).Administrator.contains(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount())) {
            i = 1;
          }
        }
      }
    }
    this.jdField_c_of_type_Boolean = true;
    localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    localObject2 = this.jdField_c_of_type_JavaLangString;
    localObject3 = new StringBuilder();
    ((StringBuilder)localObject3).append(i);
    ((StringBuilder)localObject3).append("");
    localObject3 = ((StringBuilder)localObject3).toString();
    Object localObject4 = new StringBuilder();
    ((StringBuilder)localObject4).append("");
    ((StringBuilder)localObject4).append(this.jdField_c_of_type_Int);
    ReportController.b((AppRuntime)localObject1, "P_CliOper", "Grp_manage", "", "modify_name", "complete", 0, 0, (String)localObject2, (String)localObject3, ((StringBuilder)localObject4).toString(), "");
  }
  
  public int a()
  {
    return b();
  }
  
  public Intent a(Intent paramIntent)
  {
    paramIntent.putExtra("count_type", 2);
    this.jdField_b_of_type_JavaLangString = paramIntent.getStringExtra("default_text");
    this.jdField_b_of_type_Int = paramIntent.getIntExtra("default_nick_id", 0);
    this.jdField_c_of_type_JavaLangString = paramIntent.getStringExtra("troopUin");
    this.jdField_d_of_type_JavaLangString = paramIntent.getStringExtra("uin");
    this.jdField_c_of_type_Int = paramIntent.getIntExtra("from", -1);
    this.jdField_d_of_type_Int = paramIntent.getIntExtra("edit_action", 0);
    this.jdField_a_of_type_Boolean = paramIntent.getBooleanExtra("auto_remark", false);
    if (this.jdField_a_of_type_Boolean)
    {
      Object localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
      if ((localObject != null) && (((QQAppInterface)localObject).getCurrentAccountUin() != null) && (this.jdField_d_of_type_JavaLangString != null) && (!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin().equals(this.jdField_d_of_type_JavaLangString)) && (android.text.TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString)))
      {
        localObject = (ITroopMemberInfoHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.TROOP_MEMBER_INFO_HANDLER);
        if (localObject != null) {
          ((ITroopMemberInfoHandler)localObject).a(this.jdField_d_of_type_JavaLangString);
        }
        this.jdField_b_of_type_Boolean = true;
      }
    }
    return paramIntent;
  }
  
  public View.OnClickListener a()
  {
    return null;
  }
  
  public EmoticonCallback a()
  {
    return null;
  }
  
  public OnItemSelectListener a()
  {
    return new EditTroopMemberNickService.14(this);
  }
  
  protected void a()
  {
    VasWebviewUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin(), "group_nickname", "group_nickname_8", "", 1, 0, 0, "", "", "");
    if (QLog.isColorLevel()) {
      QLog.d("ColorNick", 2, "onBackEvent. save colorNick");
    }
    a(false);
    this.jdField_a_of_type_ComTencentMobileqqTroopActivityEditinfoIEditInfoActivity.onFinish();
  }
  
  public void a(int paramInt)
  {
    if (paramInt != 1)
    {
      if (paramInt != 2)
      {
        if (paramInt != 3) {
          return;
        }
        h();
        return;
      }
      g();
      return;
    }
    f();
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (paramInt1 == 1) {
      k();
    }
  }
  
  public void a(ViewGroup paramViewGroup1, EditText paramEditText, ViewGroup paramViewGroup2)
  {
    this.jdField_a_of_type_AndroidViewView = paramViewGroup1;
    this.jdField_a_of_type_AndroidWidgetEditText = paramEditText;
    paramViewGroup1 = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext);
    try
    {
      paramViewGroup1.inflate(2131562990, paramViewGroup2, true);
    }
    catch (Exception paramViewGroup1)
    {
      if (QLog.isColorLevel())
      {
        paramEditText = new StringBuilder();
        paramEditText.append("initUI excption");
        paramEditText.append(paramViewGroup1);
        QLog.e("EditTroopMemberNickService", 2, paramEditText.toString());
      }
    }
    c();
  }
  
  public void a(IEditInfoActivity paramIEditInfoActivity)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = ((QQAppInterface)MobileQQ.sMobileQQ.waitAppRuntime(null));
    this.jdField_a_of_type_ComTencentMobileqqTroopActivityEditinfoIEditInfoActivity = paramIEditInfoActivity;
    this.jdField_a_of_type_AndroidContentContext = paramIEditInfoActivity.getContext();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqTroopApiObserverTroopObserver);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqApolloHandlerIApolloExtensionObserver);
  }
  
  void a(boolean paramBoolean)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("saveColorNick. clear = ");
      localStringBuilder.append(paramBoolean);
      QLog.d("ColorNick", 2, localStringBuilder.toString());
    }
    if (paramBoolean) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getPreferences().edit().putString("color_nick_last_edit", "").commit();
    }
    if ((!paramBoolean) && (a(null)) && (this.jdField_e_of_type_Boolean) && (!this.jdField_a_of_type_AndroidWidgetEditText.getText().toString().equals(this.jdField_b_of_type_JavaLangString)))
    {
      if (QLog.isColorLevel()) {
        QLog.d("ColorNick", 2, "saveColorNick. save currentText!");
      }
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getPreferences().edit().putString("color_nick_last_edit", this.jdField_a_of_type_AndroidWidgetEditText.getText().toString()).commit();
    }
  }
  
  public void b()
  {
    EditText localEditText = this.jdField_a_of_type_AndroidWidgetEditText;
    if ((localEditText instanceof ColorClearableEditText)) {
      ((ColorClearableEditText)localEditText).b();
    }
  }
  
  void c()
  {
    e();
    if (a()) {
      VasWebviewUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin(), "group_nickname", "uv", "", 1, 0, 0, "", "", "");
    }
    if (b())
    {
      this.jdField_a_of_type_ComTencentMobileqqProfileViewSoftInputDetectView = ((SoftInputDetectView)a(2131368888));
      this.jdField_a_of_type_ComTencentMobileqqProfileViewSoftInputDetectView.setOnImStateChangedListener(this.jdField_a_of_type_ComTencentMobileqqProfileViewSoftInputDetectView$OnImStateChangedListener);
      this.jdField_a_of_type_AndroidWidgetEditText.setEditableFactory(NickColorEmoticonBuilder.a);
      this.jdField_a_of_type_AndroidWidgetEditText.setOnClickListener(this);
      this.jdField_b_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)a(2131364834));
      this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView = ((RecyclerView)a(2131364819));
      this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView$LayoutManager = new GridLayoutManager(this.jdField_a_of_type_AndroidContentContext, 3);
      this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setLayoutManager(this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView$LayoutManager);
      this.jdField_a_of_type_ComTencentMobileqqVasColorNickColorPanelAdapter = new ColorNickColorPanelAdapter(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqVasColorNickColorPanelAdapter$OnColorSelectListener);
      this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setAdapter(this.jdField_a_of_type_ComTencentMobileqqVasColorNickColorPanelAdapter);
      this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.addOnScrollListener(this.jdField_a_of_type_ComTencentMobileqqVasColorNickColorPanelAdapter$EndlessRecyclerOnScrollListener);
      this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)a(2131364816));
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
      this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)a(2131364817));
      this.jdField_b_of_type_AndroidWidgetImageView.setOnClickListener(this);
      this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)a(2131364820));
      this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this);
      this.jdField_c_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)a(2131364821));
      this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)a(2131364833));
      this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)a(2131364831));
      this.jdField_c_of_type_AndroidWidgetTextView.setOnClickListener(this);
      this.jdField_d_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)a(2131364826));
      this.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)a(2131364824));
      this.jdField_c_of_type_AndroidWidgetImageView.setOnClickListener(this);
      this.jdField_a_of_type_ComTencentMobileqqWidgetColorNickTextView = ((ColorNickTextView)a(2131364827));
      this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)a(2131364825));
      this.jdField_d_of_type_AndroidWidgetTextView.setOnClickListener(this);
      b(false);
      b(0);
      Object localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getPreferences().getString("color_nick_last_edit", "");
      if (android.text.TextUtils.isEmpty((CharSequence)localObject))
      {
        this.jdField_d_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
      }
      else
      {
        if (QLog.isColorLevel()) {
          QLog.d("ColorNick", 2, String.format("showing last nick and clear saved color nick.", new Object[0]));
        }
        this.jdField_d_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
        localObject = new ColorNickText((CharSequence)localObject, 16).a();
        this.jdField_a_of_type_ComTencentMobileqqWidgetColorNickTextView.setText((CharSequence)localObject);
        ColorNickManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqWidgetColorNickTextView, (Spannable)localObject, this.jdField_b_of_type_Int, true);
        a(true);
      }
      localObject = this.jdField_a_of_type_AndroidWidgetEditText;
      if ((localObject instanceof ColorClearableEditText)) {
        ((ColorClearableEditText)localObject).setTextClearedListener(this.jdField_a_of_type_ComTencentMobileqqWidgetClearableEditText$OnTextClearedListener);
      }
      this.jdField_a_of_type_AndroidWidgetEditText.setFilters(new InputFilter[] { new EditTroopMemberNickService.EmojiFilter() });
      if (QVipTroopNickProcessor.c().isEnable())
      {
        d();
        this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
      }
      else
      {
        this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
      }
    }
    else if (a(null))
    {
      this.jdField_a_of_type_AndroidWidgetEditText.setText("");
    }
    int i = this.jdField_a_of_type_AndroidWidgetEditText.getText().length();
    Selection.setSelection(this.jdField_a_of_type_AndroidWidgetEditText.getEditableText(), i);
    i();
    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "Grp_set", "", "nickname edit", "nickname edit_exp", 0, 0, String.valueOf(this.jdField_c_of_type_JavaLangString), "", "", "");
  }
  
  public void d()
  {
    this.jdField_a_of_type_ComTencentMobileqqVasTroopnickShopWidgetShopLayout = ((ShopLayout)a(2131379398));
    if (this.jdField_a_of_type_ComTencentMobileqqVasTroopnickShopWidgetShopLayout != null)
    {
      if (android.text.TextUtils.isEmpty(this.jdField_c_of_type_JavaLangString)) {
        return;
      }
      this.jdField_a_of_type_ComTencentMobileqqVasTroopnickShopWidgetShopLayout.setHideInputmethod(new EditTroopMemberNickService.4(this));
      this.jdField_a_of_type_ComTencentMobileqqVasTroopnickShopWidgetShopLayout.a().a(new EditTroopMemberNickService.5(this));
      this.jdField_a_of_type_ComTencentMobileqqVasTroopnickShopWidgetShopLayout.setRequest(new TroopNickRequest(50, Long.parseLong(this.jdField_c_of_type_JavaLangString), this.jdField_a_of_type_ComTencentMobileqqVasTroopnickShopWidgetShopLayout.a()));
      ShopLayout localShopLayout = this.jdField_a_of_type_ComTencentMobileqqVasTroopnickShopWidgetShopLayout;
      if (localShopLayout != null)
      {
        localShopLayout.setShopCallback(new EditTroopMemberNickService.6(this));
        this.jdField_a_of_type_ComTencentMobileqqVasTroopnickShopWidgetShopLayout.setAppId(50);
      }
    }
  }
  
  public void delete()
  {
    com.tencent.mobileqq.text.TextUtils.backspace(this.jdField_a_of_type_AndroidWidgetEditText);
  }
  
  protected void e()
  {
    Object localObject = this.jdField_b_of_type_JavaLangString;
    if ((localObject != null) && (((String)localObject).length() > 0)) {
      if (b()) {
        this.jdField_a_of_type_AndroidWidgetEditText.setText(this.jdField_b_of_type_JavaLangString);
      } else {
        this.jdField_a_of_type_AndroidWidgetEditText.setText(ColorNickManager.b(this.jdField_b_of_type_JavaLangString));
      }
    }
    int i = this.jdField_b_of_type_Int;
    if (i > 0)
    {
      localObject = this.jdField_a_of_type_AndroidWidgetEditText;
      if ((localObject instanceof ColorClearableEditText)) {
        ((ColorClearableEditText)localObject).setCustomCloth(i, true);
      }
    }
    if (b()) {
      l();
    }
  }
  
  public void emoticonMall() {}
  
  protected void f()
  {
    ShopLayout localShopLayout = this.jdField_a_of_type_ComTencentMobileqqVasTroopnickShopWidgetShopLayout;
    if (localShopLayout != null) {
      localShopLayout.b();
    }
  }
  
  protected void g() {}
  
  protected void h()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_ComTencentMobileqqTroopApiObserverTroopObserver);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_ComTencentMobileqqApolloHandlerIApolloExtensionObserver);
    Object localObject = this.jdField_a_of_type_AndroidOsHandler;
    if (localObject != null) {
      ((Handler)localObject).removeCallbacksAndMessages(null);
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqEmoticonviewIEmoticonMainPanel;
    if (localObject != null) {
      ((IEmoticonMainPanel)localObject).onDestory();
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppSVIPObserver);
    ColorNickManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).jdField_a_of_type_AndroidOsHandler = null;
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
      break;
    case 260: 
      ColorNickManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).jdField_a_of_type_ComTencentMobileqqVasColorNickManager$ColorNickEmoticonListProvider.a(this.jdField_c_of_type_JavaUtilArrayList);
      paramMessage = this.jdField_a_of_type_ComTencentMobileqqEmoticonviewIEmoticonMainPanel;
      if (paramMessage != null) {
        paramMessage.init(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 100001, this.jdField_a_of_type_AndroidContentContext, c(), null, null, false, ColorNickManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).jdField_a_of_type_ComTencentMobileqqVasColorNickManager$ColorNickEmoticonListProvider);
      }
      break;
    case 259: 
      if (QLog.isColorLevel()) {
        QLog.d("ColorNick", 2, String.format("MSG_TYPE_CLEAR_COLOR_NICK. saveColorNick", new Object[0]));
      }
      a(false);
      e();
      break;
    case 258: 
      l();
      break;
    case 257: 
      paramMessage = this.jdField_a_of_type_ComTencentMobileqqEmoticonviewIEmoticonMainPanel;
      if (paramMessage != null)
      {
        paramMessage.setSecondTabInited(false);
        this.jdField_a_of_type_ComTencentMobileqqEmoticonviewIEmoticonMainPanel.switchTabMode(0);
      }
      break;
    }
    return true;
  }
  
  public void onClick(View paramView)
  {
    Object localObject;
    switch (paramView.getId())
    {
    default: 
      break;
    case 2131364831: 
      VasH5PayUtil.a(this.jdField_a_of_type_AndroidContentContext, "mvip.g.a.qnc_kt", "CJCLUBT", -1, false, true);
      VasWebviewUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin(), "group_nickname", "group_nickname_3", "", 1, 0, 0, "", "", "");
      break;
    case 2131364825: 
      localObject = new ColorNickText(this.jdField_a_of_type_ComTencentMobileqqWidgetColorNickTextView.getText().toString(), 32).a();
      this.jdField_a_of_type_AndroidWidgetEditText.setText((CharSequence)localObject);
      ColorNickManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidWidgetEditText, (Spannable)localObject);
      this.jdField_d_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
      break;
    case 2131364824: 
      this.jdField_d_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
      break;
    case 2131364820: 
      if (this.g == 1) {
        localObject = "2";
      } else {
        localObject = "1";
      }
      if (this.jdField_d_of_type_Boolean)
      {
        this.jdField_e_of_type_Int = 1;
        this.jdField_a_of_type_ComTencentMobileqqTroopActivityEditinfoIEditInfoActivity.hideInputMethod();
      }
      else
      {
        c(1);
      }
      VasWebviewUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin(), "group_nickname", "group_nickname_5", "", 1, 0, 0, "", (String)localObject, "");
      break;
    case 2131364817: 
      if (this.g == 2) {
        localObject = "2";
      } else {
        localObject = "1";
      }
      if (this.jdField_d_of_type_Boolean)
      {
        this.jdField_e_of_type_Int = 2;
        this.jdField_a_of_type_ComTencentMobileqqTroopActivityEditinfoIEditInfoActivity.hideInputMethod();
      }
      else
      {
        c(2);
      }
      VasWebviewUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin(), "group_nickname", "group_nickname_6", "", 1, 0, 0, "", (String)localObject, "");
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  public void onHidePopup(EmoticonInfo paramEmoticonInfo) {}
  
  public boolean onLongClick(EmoticonInfo paramEmoticonInfo)
  {
    return false;
  }
  
  public void onShowPopup(EmoticonInfo paramEmoticonInfo1, EmoticonInfo paramEmoticonInfo2, Drawable paramDrawable) {}
  
  public void send() {}
  
  public void send(EmoticonInfo paramEmoticonInfo)
  {
    EditText localEditText = this.jdField_a_of_type_AndroidWidgetEditText;
    if ((localEditText instanceof ColorClearableEditText))
    {
      this.jdField_e_of_type_Boolean = true;
      if ((paramEmoticonInfo instanceof SystemAndEmojiEmoticonInfo))
      {
        paramEmoticonInfo = (SystemAndEmojiEmoticonInfo)paramEmoticonInfo;
        if (paramEmoticonInfo.code == -1) {
          return;
        }
        int i = this.jdField_a_of_type_AndroidWidgetEditText.getSelectionStart();
        int j = this.jdField_a_of_type_AndroidWidgetEditText.getSelectionEnd();
        this.jdField_a_of_type_AndroidWidgetEditText.getEditableText().replace(i, j, com.tencent.mobileqq.text.TextUtils.getColorNickSysEmoticonString(paramEmoticonInfo.code));
        this.jdField_a_of_type_AndroidWidgetEditText.requestFocus();
        return;
      }
      if ((paramEmoticonInfo instanceof ISmallEmoticonInfo)) {
        ColorNickManager.a((ISmallEmoticonInfo)paramEmoticonInfo, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localEditText);
      }
    }
  }
  
  public void setting() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.editservice.EditTroopMemberNickService
 * JD-Core Version:    0.7.0.1
 */