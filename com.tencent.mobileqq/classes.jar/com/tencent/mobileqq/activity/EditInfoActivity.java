package com.tencent.mobileqq.activity;

import Override;
import QQService.EVIPSPEC;
import adwd;
import adwe;
import adwf;
import adwg;
import adwh;
import adwi;
import adwj;
import adwk;
import adwl;
import adwm;
import adwn;
import adwp;
import adwq;
import adwt;
import adwu;
import adwv;
import adww;
import adwx;
import adwy;
import adwz;
import adxa;
import adxb;
import adxc;
import aeow;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Bundle;
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
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import anri;
import anvi;
import anvk;
import anvx;
import aocy;
import aodb;
import aoep;
import aofu;
import arjz;
import arka;
import arlu;
import azvz;
import begq;
import begt;
import bewa;
import bhdz;
import bhls;
import bhlu;
import bhlv;
import bhlx;
import bhly;
import bhmb;
import bhmh;
import bhmi;
import bhmv;
import bhow;
import bhoy;
import bhtj;
import bhtn;
import bimn;
import bimv;
import bips;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.CardObserver;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.config.business.qvip.QVipTroopNickConfig;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.emoticonview.EmoticonCallback;
import com.tencent.mobileqq.emoticonview.EmoticonInfo;
import com.tencent.mobileqq.emoticonview.EmoticonMainPanel;
import com.tencent.mobileqq.emoticonview.HorizontalListViewEx;
import com.tencent.mobileqq.emoticonview.SmallEmoticonInfo;
import com.tencent.mobileqq.emoticonview.SystemAndEmojiEmoticonInfo;
import com.tencent.mobileqq.emoticonview.SystemAndEmojiUniversalPanel;
import com.tencent.mobileqq.emoticonview.SystemAndEmojiUniversalPanel.Builder;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.profile.view.SoftInputDetectView;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.troop.activity.TroopNickRuleFragment;
import com.tencent.mobileqq.troop.widget.PresetWordFlowLayout;
import com.tencent.mobileqq.util.DisplayUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.vas.troopnick.shop.widget.ShopLayout;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewUtil;
import com.tencent.mobileqq.widget.ClearableEditText;
import com.tencent.mobileqq.widget.ColorClearableEditText;
import com.tencent.mobileqq.widget.ColorNickTextView;
import com.tencent.mobileqq.widget.InputMethodLinearLayout;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import mqq.app.MobileQQ;
import org.json.JSONException;
import org.json.JSONObject;
import tencent.im.oidb.cmd0x8fc.Oidb_0x8fc.CommCardNameBuf;
import tencent.im.oidb.cmd0x8fc.Oidb_0x8fc.RichCardNameElem;

public class EditInfoActivity
  extends IphoneTitleBarActivity
  implements Handler.Callback, View.OnClickListener, azvz, bhlx, bimn, bips, EmoticonCallback
{
  protected int a;
  protected Drawable a;
  public Handler a;
  RecyclerView.LayoutManager jdField_a_of_type_AndroidSupportV7WidgetRecyclerView$LayoutManager;
  RecyclerView jdField_a_of_type_AndroidSupportV7WidgetRecyclerView;
  protected ViewGroup a;
  public EditText a;
  public ImageView a;
  public LinearLayout a;
  public RelativeLayout a;
  TextView jdField_a_of_type_AndroidWidgetTextView = null;
  private anvi jdField_a_of_type_Anvi = new adwm(this);
  private aodb jdField_a_of_type_Aodb = new adwp(this);
  aofu jdField_a_of_type_Aofu = new adwk(this);
  public bewa a;
  bhls jdField_a_of_type_Bhls;
  private bhlv jdField_a_of_type_Bhlv = new adwt(this);
  private bhow jdField_a_of_type_Bhow = new adwq(this);
  private CardObserver jdField_a_of_type_ComTencentMobileqqAppCardObserver = new adwl(this);
  EmoticonMainPanel jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel;
  SystemAndEmojiUniversalPanel jdField_a_of_type_ComTencentMobileqqEmoticonviewSystemAndEmojiUniversalPanel = null;
  SoftInputDetectView jdField_a_of_type_ComTencentMobileqqProfileViewSoftInputDetectView;
  PresetWordFlowLayout jdField_a_of_type_ComTencentMobileqqTroopWidgetPresetWordFlowLayout;
  ShopLayout jdField_a_of_type_ComTencentMobileqqVasTroopnickShopWidgetShopLayout;
  ColorNickTextView jdField_a_of_type_ComTencentMobileqqWidgetColorNickTextView;
  InputMethodLinearLayout jdField_a_of_type_ComTencentMobileqqWidgetInputMethodLinearLayout;
  protected String a;
  public ArrayList<String> a;
  public boolean a;
  private bhlu[] jdField_a_of_type_ArrayOfBhlu = { new bhlu(2, null, 0, null) };
  protected int b;
  ImageView jdField_b_of_type_AndroidWidgetImageView;
  LinearLayout jdField_b_of_type_AndroidWidgetLinearLayout;
  RelativeLayout jdField_b_of_type_AndroidWidgetRelativeLayout;
  TextView jdField_b_of_type_AndroidWidgetTextView = null;
  public String b;
  private ArrayList<bhlu> jdField_b_of_type_JavaUtilArrayList = new ArrayList();
  public boolean b;
  public int c;
  ImageView jdField_c_of_type_AndroidWidgetImageView;
  RelativeLayout jdField_c_of_type_AndroidWidgetRelativeLayout;
  TextView jdField_c_of_type_AndroidWidgetTextView;
  public String c;
  private ArrayList<Integer> jdField_c_of_type_JavaUtilArrayList = new ArrayList();
  protected boolean c;
  public int d;
  ImageView jdField_d_of_type_AndroidWidgetImageView;
  RelativeLayout jdField_d_of_type_AndroidWidgetRelativeLayout;
  TextView jdField_d_of_type_AndroidWidgetTextView;
  String jdField_d_of_type_JavaLangString = "";
  protected boolean d;
  public int e;
  ImageView jdField_e_of_type_AndroidWidgetImageView;
  TextView jdField_e_of_type_AndroidWidgetTextView;
  public String e;
  boolean jdField_e_of_type_Boolean = true;
  public int f;
  TextView jdField_f_of_type_AndroidWidgetTextView;
  public String f;
  boolean jdField_f_of_type_Boolean = false;
  public int g;
  String g;
  public boolean g;
  public int h;
  protected String h;
  public boolean h;
  public int i;
  String jdField_i_of_type_JavaLangString;
  boolean jdField_i_of_type_Boolean = false;
  private int j;
  protected String j;
  public boolean j;
  private int jdField_k_of_type_Int;
  boolean jdField_k_of_type_Boolean = true;
  private int jdField_l_of_type_Int;
  private boolean jdField_l_of_type_Boolean;
  private boolean m;
  
  public EditInfoActivity()
  {
    this.jdField_a_of_type_AndroidWidgetLinearLayout = null;
    this.jdField_a_of_type_Int = -1;
    this.jdField_b_of_type_Int = -1;
    this.jdField_c_of_type_JavaLangString = "";
    this.jdField_d_of_type_Int = 0;
    this.jdField_e_of_type_Int = -1;
    this.jdField_g_of_type_Boolean = false;
    this.jdField_h_of_type_Boolean = false;
    this.jdField_f_of_type_Int = 0;
    this.jdField_g_of_type_Int = 0;
    this.jdField_h_of_type_Int = 0;
    this.jdField_i_of_type_Int = 0;
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_a_of_type_AndroidOsHandler = new Handler(this);
  }
  
  private int a()
  {
    if (a(new adxc()))
    {
      localObject1 = ((ColorClearableEditText)this.jdField_a_of_type_AndroidWidgetEditText).a();
      ArrayList localArrayList = new ArrayList();
      Iterator localIterator = ((ArrayList)localObject1).iterator();
      if (localIterator.hasNext())
      {
        localObject1 = (bimv)localIterator.next();
        Oidb_0x8fc.RichCardNameElem localRichCardNameElem = new Oidb_0x8fc.RichCardNameElem();
        switch (((bimv)localObject1).jdField_c_of_type_Int)
        {
        }
        for (;;)
        {
          localArrayList.add(localRichCardNameElem);
          break;
          localRichCardNameElem.bytes_text.set(ByteStringMicro.copyFrom(((bimv)localObject1).jdField_a_of_type_JavaLangString.getBytes()));
          continue;
          Object localObject2 = ((bimv)localObject1).jdField_a_of_type_JavaLangString;
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
      localObject1 = new Oidb_0x8fc.CommCardNameBuf();
      ((Oidb_0x8fc.CommCardNameBuf)localObject1).rpt_rich_card_name.set(localArrayList);
      return ((Oidb_0x8fc.CommCardNameBuf)localObject1).toByteArray().length;
    }
    Object localObject1 = this.jdField_a_of_type_AndroidWidgetEditText.getText();
    if (localObject1 == null) {}
    int n;
    for (localObject1 = "";; localObject1 = localObject1.toString())
    {
      n = ((String)localObject1).trim().length();
      try
      {
        int i1 = ((String)localObject1).trim().getBytes("utf-8").length;
        return i1;
      }
      catch (UnsupportedEncodingException localUnsupportedEncodingException)
      {
        if (!QLog.isColorLevel()) {
          return n;
        }
        QLog.d("ColorNick", 2, "UnsupportedEncodingException:" + localUnsupportedEncodingException.getMessage());
      }
    }
    return n;
  }
  
  private void a(int paramInt)
  {
    this.app.addObserver(this.jdField_a_of_type_Aodb);
    ((aocy)this.app.getBusinessHandler(BusinessHandlerFactory.SVIP_HANDLER)).e(paramInt);
  }
  
  private boolean a()
  {
    return (this.jdField_g_of_type_Boolean) && (this.jdField_f_of_type_JavaLangString.equals(this.app.getCurrentAccountUin()));
  }
  
  /* Error */
  private boolean a(adxc paramadxc)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore 4
    //   3: aload_1
    //   4: ifnull +18 -> 22
    //   7: aload_1
    //   8: iconst_0
    //   9: putfield 357	adxc:jdField_b_of_type_Boolean	Z
    //   12: aload_1
    //   13: iconst_0
    //   14: putfield 359	adxc:jdField_a_of_type_Boolean	Z
    //   17: aload_1
    //   18: iconst_0
    //   19: putfield 361	adxc:jdField_c_of_type_Boolean	Z
    //   22: aload_0
    //   23: getfield 177	com/tencent/mobileqq/activity/EditInfoActivity:jdField_a_of_type_AndroidWidgetEditText	Landroid/widget/EditText;
    //   26: instanceof 179
    //   29: ifeq +218 -> 247
    //   32: aload_0
    //   33: getfield 177	com/tencent/mobileqq/activity/EditInfoActivity:jdField_a_of_type_AndroidWidgetEditText	Landroid/widget/EditText;
    //   36: checkcast 179	com/tencent/mobileqq/widget/ColorClearableEditText
    //   39: astore 7
    //   41: aload 7
    //   43: invokevirtual 362	com/tencent/mobileqq/widget/ColorClearableEditText:a	()I
    //   46: ifle +14 -> 60
    //   49: aload_1
    //   50: ifnull +10 -> 60
    //   53: aload_1
    //   54: iconst_1
    //   55: putfield 361	adxc:jdField_c_of_type_Boolean	Z
    //   58: iconst_1
    //   59: ireturn
    //   60: aload 7
    //   62: invokevirtual 364	com/tencent/mobileqq/widget/ColorClearableEditText:a	()V
    //   65: aload 7
    //   67: invokevirtual 182	com/tencent/mobileqq/widget/ColorClearableEditText:a	()Ljava/util/ArrayList;
    //   70: astore 7
    //   72: aload 7
    //   74: ifnull +173 -> 247
    //   77: aload 7
    //   79: invokevirtual 367	java/util/ArrayList:size	()I
    //   82: ifle +165 -> 247
    //   85: aload 7
    //   87: invokevirtual 186	java/util/ArrayList:iterator	()Ljava/util/Iterator;
    //   90: astore 7
    //   92: iconst_0
    //   93: istore 4
    //   95: iconst_0
    //   96: istore_3
    //   97: aload 7
    //   99: invokeinterface 192 1 0
    //   104: ifeq +128 -> 232
    //   107: aload 7
    //   109: invokeinterface 196 1 0
    //   114: checkcast 198	bimv
    //   117: astore 8
    //   119: aload 8
    //   121: getfield 203	bimv:jdField_c_of_type_Int	I
    //   124: istore_2
    //   125: iload_2
    //   126: iconst_1
    //   127: if_icmpne +51 -> 178
    //   130: iconst_1
    //   131: istore 5
    //   133: iload_3
    //   134: istore 6
    //   136: iload 5
    //   138: istore 4
    //   140: iload 6
    //   142: istore_3
    //   143: iload 6
    //   145: ifeq -48 -> 97
    //   148: iload 5
    //   150: istore 4
    //   152: iload 6
    //   154: istore_3
    //   155: iload 5
    //   157: ifeq -60 -> 97
    //   160: aload_1
    //   161: ifnull +15 -> 176
    //   164: aload_1
    //   165: iload 6
    //   167: putfield 357	adxc:jdField_b_of_type_Boolean	Z
    //   170: aload_1
    //   171: iload 5
    //   173: putfield 359	adxc:jdField_a_of_type_Boolean	Z
    //   176: iconst_1
    //   177: ireturn
    //   178: aload 8
    //   180: getfield 203	bimv:jdField_c_of_type_Int	I
    //   183: iconst_3
    //   184: if_icmpne +13 -> 197
    //   187: iconst_1
    //   188: istore 6
    //   190: iload 4
    //   192: istore 5
    //   194: goto -58 -> 136
    //   197: aload 8
    //   199: getfield 203	bimv:jdField_c_of_type_Int	I
    //   202: istore_2
    //   203: iload 4
    //   205: istore 5
    //   207: iload_3
    //   208: istore 6
    //   210: iload_2
    //   211: iconst_2
    //   212: if_icmpne -76 -> 136
    //   215: aload_1
    //   216: ifnull +14 -> 230
    //   219: aload_1
    //   220: iload_3
    //   221: putfield 357	adxc:jdField_b_of_type_Boolean	Z
    //   224: aload_1
    //   225: iload 4
    //   227: putfield 359	adxc:jdField_a_of_type_Boolean	Z
    //   230: iconst_1
    //   231: ireturn
    //   232: aload_1
    //   233: ifnull +14 -> 247
    //   236: aload_1
    //   237: iload_3
    //   238: putfield 357	adxc:jdField_b_of_type_Boolean	Z
    //   241: aload_1
    //   242: iload 4
    //   244: putfield 359	adxc:jdField_a_of_type_Boolean	Z
    //   247: iconst_0
    //   248: ireturn
    //   249: astore 7
    //   251: iconst_0
    //   252: istore_3
    //   253: aload_1
    //   254: ifnull +14 -> 268
    //   257: aload_1
    //   258: iload_3
    //   259: putfield 357	adxc:jdField_b_of_type_Boolean	Z
    //   262: aload_1
    //   263: iload 4
    //   265: putfield 359	adxc:jdField_a_of_type_Boolean	Z
    //   268: aload 7
    //   270: athrow
    //   271: astore 7
    //   273: goto -20 -> 253
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	276	0	this	EditInfoActivity
    //   0	276	1	paramadxc	adxc
    //   124	89	2	n	int
    //   96	163	3	bool1	boolean
    //   1	263	4	bool2	boolean
    //   131	75	5	bool3	boolean
    //   134	75	6	bool4	boolean
    //   39	69	7	localObject1	Object
    //   249	20	7	localObject2	Object
    //   271	1	7	localObject3	Object
    //   117	81	8	localbimv	bimv
    // Exception table:
    //   from	to	target	type
    //   85	92	249	finally
    //   97	125	271	finally
    //   178	187	271	finally
    //   197	203	271	finally
  }
  
  private void b(int paramInt)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      this.jdField_j_of_type_Int = 0;
      return;
      if (this.jdField_l_of_type_Int == 1)
      {
        a();
      }
      else
      {
        this.jdField_l_of_type_Int = 1;
        this.jdField_d_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
        bhmb.a(this.app).jdField_a_of_type_AndroidOsHandler = this.jdField_a_of_type_AndroidOsHandler;
        this.jdField_c_of_type_AndroidWidgetImageView.setImageResource(2130847079);
        this.jdField_b_of_type_AndroidWidgetImageView.setImageResource(2130847084);
        this.jdField_b_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
        this.jdField_c_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
        this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setVisibility(8);
        ((RelativeLayout.LayoutParams)this.jdField_b_of_type_AndroidWidgetRelativeLayout.getLayoutParams()).height = DisplayUtil.dip2px(this, 387.0F);
        ((RelativeLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetRelativeLayout.getLayoutParams()).bottomMargin = DisplayUtil.dip2px(this, 387.0F);
        if (this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel == null)
        {
          this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel = ((EmoticonMainPanel)View.inflate(getBaseContext(), 2131559158, null));
          if (this.jdField_e_of_type_Int == 0) {
            this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel.setFilterSysFaceBeyond255Enable(true);
          }
          this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel.setCallBack(this);
          this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel.disableGuide = true;
          this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel.disableMoreEmotionButton = true;
          this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel.hasBigEmotion = false;
          this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel.onlySysAndEmoji = true;
          this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel.disableAutoDownload = true;
          this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel.init(this.app, 100001, this, getTitleBarHeight(), null, null, false, bhmb.a(this.app).jdField_a_of_type_Bhmi);
          this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel.mEmoticonTabs.setOverScrollMode(2);
          this.jdField_c_of_type_AndroidWidgetRelativeLayout.addView(this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel);
          continue;
          if (this.jdField_l_of_type_Int == 2)
          {
            a();
          }
          else
          {
            this.jdField_l_of_type_Int = 2;
            this.jdField_d_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
            bhmb.a(this.app).jdField_a_of_type_AndroidOsHandler = this.jdField_a_of_type_AndroidOsHandler;
            this.jdField_c_of_type_AndroidWidgetImageView.setImageResource(2130847078);
            this.jdField_b_of_type_AndroidWidgetImageView.setImageResource(2130847085);
            this.jdField_b_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
            this.jdField_c_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
            this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setVisibility(0);
            ((RelativeLayout.LayoutParams)this.jdField_b_of_type_AndroidWidgetRelativeLayout.getLayoutParams()).height = DisplayUtil.dip2px(this, 388.0F);
            ((RelativeLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetRelativeLayout.getLayoutParams()).bottomMargin = DisplayUtil.dip2px(this, 388.0F);
          }
        }
      }
    }
  }
  
  private boolean b()
  {
    arjz localarjz = arka.c();
    if (localarjz == null) {
      return a();
    }
    return (localarjz.jdField_a_of_type_Boolean) && (a());
  }
  
  private void d(boolean paramBoolean)
  {
    Object localObject = new ArrayList();
    Collections.addAll((Collection)localObject, this.jdField_a_of_type_ArrayOfBhlu);
    ((ArrayList)localObject).addAll(this.jdField_b_of_type_JavaUtilArrayList);
    this.jdField_a_of_type_Bhls.a((List)localObject, paramBoolean);
    localObject = ((anvk)this.app.getManager(QQManagerFactory.FRIENDS_MANAGER)).e(this.jdField_f_of_type_JavaLangString);
    if (localObject != null)
    {
      if (((Friends)localObject).isServiceEnabled(EVIPSPEC.E_SP_SUPERVIP))
      {
        this.jdField_c_of_type_AndroidWidgetTextView.setText(getString(2131690867));
        this.jdField_d_of_type_AndroidWidgetTextView.setText(getString(2131690868));
      }
    }
    else {
      return;
    }
    this.jdField_c_of_type_AndroidWidgetTextView.setText(getString(2131690865));
    this.jdField_d_of_type_AndroidWidgetTextView.setText(getString(2131690866));
  }
  
  private void n()
  {
    if (QLog.isColorLevel()) {
      QLog.d("EditInfoActivity", 2, "initGetTroopNickRule mIsEditMode = " + this.jdField_k_of_type_Boolean + ", isTroopNick = " + this.jdField_g_of_type_Boolean);
    }
    this.jdField_b_of_type_AndroidWidgetLinearLayout = ((LinearLayout)findViewById(2131379569));
    if (this.jdField_b_of_type_AndroidWidgetLinearLayout == null) {}
    do
    {
      return;
      this.jdField_b_of_type_AndroidWidgetLinearLayout.setVerticalScrollBarEnabled(false);
      this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131366022));
    } while (this.jdField_a_of_type_AndroidWidgetTextView == null);
    this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(new adwv(this));
    if ((this.jdField_k_of_type_Boolean) && (this.jdField_g_of_type_Boolean))
    {
      this.jdField_f_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131379568));
      this.jdField_e_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131379566));
      this.jdField_e_of_type_AndroidWidgetImageView.setOnClickListener(new adww(this));
      if (ThemeUtil.isInNightMode(this.app)) {
        this.jdField_e_of_type_AndroidWidgetImageView.setBackgroundDrawable(getResources().getDrawable(2130846168));
      }
      this.jdField_a_of_type_ComTencentMobileqqTroopWidgetPresetWordFlowLayout = ((PresetWordFlowLayout)findViewById(2131379570));
      this.jdField_a_of_type_ComTencentMobileqqTroopWidgetPresetWordFlowLayout.jdField_b_of_type_Int = ViewUtils.dpToPx(12.0F);
      this.jdField_a_of_type_ComTencentMobileqqTroopWidgetPresetWordFlowLayout.jdField_d_of_type_Int = ViewUtils.dpToPx(12.0F);
      this.jdField_a_of_type_Bewa = new bewa();
      if (ThemeUtil.isInNightMode(this.app)) {
        this.jdField_a_of_type_Bewa.b();
      }
      this.jdField_a_of_type_Bewa.c();
      this.jdField_a_of_type_Bewa.a = new adwx(this);
      this.jdField_a_of_type_ComTencentMobileqqTroopWidgetPresetWordFlowLayout.setAdapter(this.jdField_a_of_type_Bewa);
      p();
      return;
    }
    this.jdField_b_of_type_AndroidWidgetLinearLayout.setVisibility(8);
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
  }
  
  private void o()
  {
    Object localObject1 = (TroopManager)this.app.getManager(QQManagerFactory.TROOP_MANAGER);
    Object localObject2;
    if (localObject1 != null)
    {
      localObject2 = ((TroopManager)localObject1).b(this.jdField_e_of_type_JavaLangString);
      if (localObject2 != null)
      {
        localObject1 = new Intent();
        ((Intent)localObject1).putExtra(TroopNickRuleFragment.jdField_a_of_type_JavaLangString, this.jdField_e_of_type_JavaLangString);
        ((Intent)localObject1).putExtra(TroopNickRuleFragment.jdField_b_of_type_JavaLangString, ((TroopInfo)localObject2).groupCardPrefixIntro);
        if (this.jdField_e_of_type_Int != 0) {
          break label112;
        }
        ((Intent)localObject1).putExtra(TroopNickRuleFragment.jdField_d_of_type_JavaLangString, "1");
      }
    }
    for (;;)
    {
      localObject2 = ((TroopInfo)localObject2).getGroupCardPrefix();
      if (localObject2 != null) {
        ((Intent)localObject1).putStringArrayListExtra(TroopNickRuleFragment.jdField_c_of_type_JavaLangString, (ArrayList)localObject2);
      }
      aeow.a(this, (Intent)localObject1, PublicFragmentActivity.class, TroopNickRuleFragment.class, 1);
      return;
      label112:
      ((Intent)localObject1).putExtra(TroopNickRuleFragment.jdField_d_of_type_JavaLangString, "3");
    }
  }
  
  private void p()
  {
    int i2 = 0;
    Object localObject1 = (TroopManager)this.app.getManager(QQManagerFactory.TROOP_MANAGER);
    label118:
    int i1;
    if (localObject1 != null)
    {
      localObject1 = ((TroopManager)localObject1).b(this.jdField_e_of_type_JavaLangString);
      if (localObject1 != null)
      {
        this.jdField_a_of_type_JavaUtilArrayList = ((TroopInfo)localObject1).getGroupCardPrefix();
        Object localObject2;
        if (this.jdField_a_of_type_ComTencentMobileqqTroopWidgetPresetWordFlowLayout != null)
        {
          localObject2 = this.jdField_a_of_type_ComTencentMobileqqTroopWidgetPresetWordFlowLayout;
          if (!this.jdField_a_of_type_JavaUtilArrayList.isEmpty()) {
            break label254;
          }
          n = 8;
          ((PresetWordFlowLayout)localObject2).setVisibility(n);
          r();
        }
        this.jdField_j_of_type_JavaLangString = ((TroopInfo)localObject1).groupCardPrefixIntro;
        if (this.jdField_f_of_type_AndroidWidgetTextView != null)
        {
          localObject2 = this.jdField_f_of_type_AndroidWidgetTextView;
          if (!android.text.TextUtils.isEmpty(this.jdField_j_of_type_JavaLangString)) {
            break label259;
          }
          n = 8;
          ((TextView)localObject2).setVisibility(n);
          this.jdField_f_of_type_AndroidWidgetTextView.setText(this.jdField_j_of_type_JavaLangString);
        }
        if ((this.jdField_a_of_type_JavaUtilArrayList.isEmpty()) && (android.text.TextUtils.isEmpty(this.jdField_j_of_type_JavaLangString))) {
          break label264;
        }
        n = 1;
        label157:
        if (this.jdField_b_of_type_AndroidWidgetLinearLayout != null)
        {
          localObject2 = this.jdField_b_of_type_AndroidWidgetLinearLayout;
          if (n == 0) {
            break label269;
          }
          i1 = 0;
          label176:
          ((LinearLayout)localObject2).setVisibility(i1);
        }
        boolean bool = ((TroopInfo)localObject1).isOwnerOrAdmin(getCurrentAccountUin());
        if (this.jdField_e_of_type_AndroidWidgetImageView != null)
        {
          localObject1 = this.jdField_e_of_type_AndroidWidgetImageView;
          if ((n == 0) || (!bool)) {
            break label275;
          }
          i1 = 0;
          label217:
          ((ImageView)localObject1).setVisibility(i1);
        }
        if (this.jdField_a_of_type_AndroidWidgetTextView != null)
        {
          localObject1 = this.jdField_a_of_type_AndroidWidgetTextView;
          if ((n != 0) || (!bool)) {
            break label281;
          }
        }
      }
    }
    label259:
    label264:
    label269:
    label275:
    label281:
    for (int n = i2;; n = 8)
    {
      ((TextView)localObject1).setVisibility(n);
      return;
      label254:
      n = 0;
      break;
      n = 0;
      break label118;
      n = 0;
      break label157;
      i1 = 8;
      break label176;
      i1 = 8;
      break label217;
    }
  }
  
  private void q()
  {
    SpannableString localSpannableString = new begq(this.jdField_a_of_type_AndroidWidgetEditText.getText().toString(), 16).a();
    bhmb.a(this.app, this.jdField_a_of_type_AndroidWidgetEditText, localSpannableString, this.jdField_c_of_type_Int, true);
  }
  
  private void r()
  {
    Object localObject;
    if (this.jdField_a_of_type_Bewa != null)
    {
      this.jdField_a_of_type_Bewa.a();
      localObject = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      while (((Iterator)localObject).hasNext())
      {
        String str = (String)((Iterator)localObject).next();
        this.jdField_a_of_type_Bewa.a(str);
      }
      localObject = this.jdField_a_of_type_ComTencentMobileqqTroopWidgetPresetWordFlowLayout;
      if (this.jdField_a_of_type_Bewa.getCount() != 0) {
        break label83;
      }
    }
    label83:
    for (int n = 8;; n = 0)
    {
      ((PresetWordFlowLayout)localObject).setVisibility(n);
      this.jdField_a_of_type_Bewa.notifyDataSetChanged();
      return;
    }
  }
  
  public void a()
  {
    InputMethodManager localInputMethodManager = (InputMethodManager)getSystemService("input_method");
    if ((this.jdField_a_of_type_AndroidWidgetEditText != null) && (this.jdField_k_of_type_Boolean))
    {
      if (QLog.isColorLevel()) {
        QLog.i("EditInfoActivity", 2, String.format("showInputMethod()", new Object[0]));
      }
      localInputMethodManager.showSoftInput(this.jdField_a_of_type_AndroidWidgetEditText, 2);
    }
  }
  
  public void a(Intent paramIntent) {}
  
  protected void a(EditText paramEditText)
  {
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)super.findViewById(2131366024));
    this.jdField_b_of_type_AndroidWidgetTextView.setText(this.jdField_c_of_type_JavaLangString);
    paramEditText.addTextChangedListener(new adwh(this, paramEditText));
  }
  
  public void a(bhlu parambhlu)
  {
    ColorClearableEditText localColorClearableEditText;
    String str;
    int i1;
    int n;
    if ((this.jdField_a_of_type_AndroidWidgetEditText instanceof ColorClearableEditText))
    {
      this.m = true;
      localColorClearableEditText = (ColorClearableEditText)this.jdField_a_of_type_AndroidWidgetEditText;
      str = bhmb.a(parambhlu);
      bhmv[] arrayOfbhmv = (bhmv[])this.jdField_a_of_type_AndroidWidgetEditText.getEditableText().getSpans(0, this.jdField_a_of_type_AndroidWidgetEditText.getEditableText().length(), bhmv.class);
      if ((arrayOfbhmv == null) || (arrayOfbhmv.length <= 0)) {
        break label260;
      }
      i1 = this.jdField_a_of_type_AndroidWidgetEditText.getEditableText().getSpanStart(arrayOfbhmv[0]);
      n = this.jdField_a_of_type_AndroidWidgetEditText.getEditableText().getSpanEnd(arrayOfbhmv[0]);
      this.jdField_a_of_type_AndroidWidgetEditText.getEditableText().removeSpan(arrayOfbhmv[0]);
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidWidgetEditText.getEditableText().replace(i1, n, str);
      switch (parambhlu.jdField_a_of_type_Int)
      {
      }
      do
      {
        return;
        if (parambhlu.jdField_b_of_type_Int != 0) {
          localColorClearableEditText.setTextColor(parambhlu.jdField_b_of_type_Int);
        }
        for (;;)
        {
          localColorClearableEditText.setSpecialColor(0, null, null, 0, null);
          return;
          localColorClearableEditText.setTextColor(-16777216);
        }
        localColorClearableEditText.setTextColor(-16777216);
        parambhlu = bhmb.a(this.app).a(parambhlu.jdField_b_of_type_Int);
      } while (parambhlu == null);
      localColorClearableEditText.setSpecialColor(parambhlu.jdField_a_of_type_Int, parambhlu.jdField_a_of_type_ArrayOfInt, parambhlu.jdField_a_of_type_ArrayOfFloat, parambhlu.jdField_b_of_type_Int, parambhlu.jdField_a_of_type_AndroidGraphicsBitmap);
      return;
      label260:
      n = 0;
      i1 = 0;
    }
  }
  
  public void a(String paramString)
  {
    Object localObject;
    switch (this.jdField_h_of_type_Int)
    {
    default: 
      localObject = new Intent();
      ((Intent)localObject).putExtra("type", this.jdField_a_of_type_Int);
      ((Intent)localObject).putExtra("subtype", this.jdField_b_of_type_Int);
      ((Intent)localObject).putExtra("result", paramString);
      a((Intent)localObject);
      setResult(-1, (Intent)localObject);
      f(this);
    case 1: 
      do
      {
        return;
        if (!NetworkUtil.isNetSupport(this.app.getApplication().getApplicationContext()))
        {
          QQToast.a(this, 1, 2131694255, 0).b(getTitleBarHeight());
          return;
        }
        if (QLog.isColorLevel()) {
          QLog.d("EditInfoActivity", 2, String.format("edit self nick, uin: %s, result: %s", new Object[] { this.jdField_f_of_type_JavaLangString, paramString }));
        }
      } while ((android.text.TextUtils.isEmpty(paramString.trim())) || (!this.jdField_f_of_type_JavaLangString.equals(this.app.getCurrentAccountUin())));
      b(true);
      localObject = new Bundle();
      ((Bundle)localObject).putString("nick", paramString.trim());
      ((anri)this.app.getBusinessHandler(BusinessHandlerFactory.CARD_HANLDER)).a((Bundle)localObject);
      this.jdField_j_of_type_Boolean = true;
      return;
    }
    if (!NetworkUtil.isNetSupport(this.app.getApplication().getApplicationContext()))
    {
      QQToast.a(this, 1, 2131694255, 0).b(getTitleBarHeight());
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("EditInfoActivity", 2, String.format("edit friend remark, uin: %s, result: %s", new Object[] { this.jdField_f_of_type_JavaLangString, paramString }));
    }
    b(true);
    ((FriendListHandler)this.app.getBusinessHandler(BusinessHandlerFactory.FRIENDLIST_HANDLER)).setFriendComment(this.jdField_f_of_type_JavaLangString, paramString, false);
    this.jdField_j_of_type_Boolean = true;
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_b_of_type_Boolean = paramBoolean;
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetInputMethodLinearLayout == null) {}
    do
    {
      do
      {
        return;
        if (!paramBoolean) {
          break;
        }
      } while ((this.jdField_a_of_type_AndroidWidgetLinearLayout == null) || (this.jdField_a_of_type_AndroidWidgetImageView == null));
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130847907);
      this.jdField_a_of_type_AndroidWidgetImageView.setContentDescription(anvx.a(2131703113));
      return;
    } while ((!this.jdField_a_of_type_Boolean) || (this.jdField_a_of_type_AndroidWidgetLinearLayout == null));
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
  }
  
  public void a(boolean paramBoolean, int paramInt)
  {
    this.jdField_l_of_type_Boolean = paramBoolean;
    if (paramBoolean)
    {
      this.jdField_a_of_type_AndroidWidgetEditText.setCursorVisible(true);
      this.jdField_l_of_type_Int = 0;
      if (this.jdField_b_of_type_AndroidWidgetRelativeLayout != null) {
        this.jdField_b_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
      }
      if (this.jdField_a_of_type_AndroidWidgetRelativeLayout != null)
      {
        this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
        ((RelativeLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetRelativeLayout.getLayoutParams()).bottomMargin = 0;
        this.jdField_b_of_type_AndroidWidgetImageView.setImageResource(2130847085);
        this.jdField_c_of_type_AndroidWidgetImageView.setImageResource(2130847079);
      }
      return;
    }
    if (this.jdField_j_of_type_Int > 0)
    {
      b(this.jdField_j_of_type_Int);
      return;
    }
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
    this.jdField_a_of_type_AndroidWidgetEditText.setCursorVisible(false);
  }
  
  public boolean a(String paramString)
  {
    boolean bool = false;
    if (paramString.length() > 20) {
      return true;
    }
    int i1 = paramString.length();
    int n = 0;
    while (n < i1)
    {
      int i2 = paramString.charAt(n);
      if ((i2 < 48) || (i2 > 57)) {
        bool = true;
      }
      n += 1;
    }
    return bool;
  }
  
  public boolean a(String paramString1, String paramString2)
  {
    if (this.jdField_h_of_type_Int == 1)
    {
      if (android.text.TextUtils.isEmpty(paramString2))
      {
        if (android.text.TextUtils.isEmpty(paramString1))
        {
          QQToast.a(this, getString(2131693190), 0).b(getTitleBarHeight());
          return false;
        }
        QQToast.a(this, getString(2131693191), 0).b(getTitleBarHeight());
        return false;
      }
    }
    else if ((this.jdField_h_of_type_Int == 2) && (android.text.TextUtils.isEmpty(paramString2)) && (!android.text.TextUtils.isEmpty(paramString1)))
    {
      QQToast.a(this, getString(2131693193), 0).b(getTitleBarHeight());
      return false;
    }
    return true;
  }
  
  public void b()
  {
    InputMethodManager localInputMethodManager = (InputMethodManager)getSystemService("input_method");
    View localView = getWindow().peekDecorView();
    if ((localView != null) && (localView.getWindowToken() != null)) {
      localInputMethodManager.hideSoftInputFromWindow(localView.getWindowToken(), 0);
    }
  }
  
  public void b(boolean paramBoolean)
  {
    if (this.centerView == null) {
      this.centerView = ((TextView)findViewById(2131369278));
    }
    if (paramBoolean)
    {
      this.rightViewText.setEnabled(false);
      if ((this.jdField_a_of_type_JavaLangString != null) && (this.jdField_a_of_type_AndroidGraphicsDrawableDrawable == null))
      {
        this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = getResources().getDrawable(2130839466);
        this.centerView.setCompoundDrawablesWithIntrinsicBounds(this.jdField_a_of_type_AndroidGraphicsDrawableDrawable, null, null, null);
        ((Animatable)this.jdField_a_of_type_AndroidGraphicsDrawableDrawable).start();
      }
    }
    do
    {
      return;
      this.rightViewText.setEnabled(true);
    } while ((this.jdField_a_of_type_JavaLangString == null) || (this.jdField_a_of_type_AndroidGraphicsDrawableDrawable == null));
    ((Animatable)this.jdField_a_of_type_AndroidGraphicsDrawableDrawable).stop();
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = null;
    this.centerView.setCompoundDrawables(null, null, null, null);
  }
  
  void c()
  {
    switch (this.jdField_a_of_type_Int)
    {
    }
    for (;;)
    {
      int n = this.jdField_a_of_type_AndroidWidgetEditText.getText().length();
      Selection.setSelection(this.jdField_a_of_type_AndroidWidgetEditText.getEditableText(), n);
      setTitle(this.jdField_a_of_type_JavaLangString);
      setRightButton(2131692403, new adwn(this));
      if (this.jdField_g_of_type_JavaLangString != null)
      {
        this.rightViewText.setText(this.jdField_g_of_type_JavaLangString);
        this.rightViewText.setContentDescription(getString(2131697521, new Object[] { this.jdField_g_of_type_JavaLangString }));
      }
      if (this.jdField_h_of_type_JavaLangString != null)
      {
        this.leftView.setText(this.jdField_h_of_type_JavaLangString);
        this.leftView.setContentDescription(getString(2131697521, new Object[] { this.jdField_h_of_type_JavaLangString }));
      }
      if (!this.jdField_k_of_type_Boolean) {
        this.rightViewText.setVisibility(8);
      }
      if ((this.jdField_g_of_type_Boolean) && (!this.jdField_k_of_type_Boolean)) {
        this.jdField_a_of_type_AndroidWidgetEditText.setOnClickListener(this);
      }
      if (this.jdField_h_of_type_Boolean) {
        this.jdField_a_of_type_AndroidWidgetEditText.setOnClickListener(this);
      }
      if (this.jdField_i_of_type_JavaLangString != null)
      {
        TextView localTextView = (TextView)findViewById(2131378758);
        if (localTextView != null)
        {
          localTextView.setVisibility(0);
          localTextView.setText(this.jdField_i_of_type_JavaLangString);
          localTextView.setOnClickListener(new adwu(this));
        }
      }
      n();
      if ((this.jdField_k_of_type_Boolean) && (this.jdField_g_of_type_Boolean)) {
        this.app.reportClickEvent("dc00899", "Grp_set", "", "nickname edit", "nickname edit_exp", 0, 0, String.valueOf(this.jdField_e_of_type_JavaLangString), "", "", "");
      }
      return;
      d();
      continue;
      g();
      continue;
      f();
    }
  }
  
  public void c(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ColorNick", 2, "saveColorNick. clear = " + paramBoolean);
    }
    if (paramBoolean) {
      this.app.getPreferences().edit().putString("color_nick_last_edit", "").commit();
    }
    if ((!paramBoolean) && (a(null)) && (this.m) && (!this.jdField_a_of_type_AndroidWidgetEditText.getText().toString().equals(this.jdField_b_of_type_JavaLangString)))
    {
      if (QLog.isColorLevel()) {
        QLog.d("ColorNick", 2, "saveColorNick. save currentText!");
      }
      this.app.getPreferences().edit().putString("color_nick_last_edit", this.jdField_a_of_type_AndroidWidgetEditText.getText().toString()).commit();
    }
  }
  
  protected void d()
  {
    super.setContentView(2131559155);
    h();
    if (a()) {
      VasWebviewUtil.reportCommercialDrainage(this.app.getCurrentUin(), "group_nickname", "uv", "", 1, 0, 0, "", "", "");
    }
    if (b())
    {
      this.jdField_a_of_type_ComTencentMobileqqProfileViewSoftInputDetectView = ((SoftInputDetectView)super.findViewById(2131368924));
      this.jdField_a_of_type_ComTencentMobileqqProfileViewSoftInputDetectView.setOnImStateChangedListener(this);
      this.jdField_a_of_type_AndroidWidgetEditText.setEditableFactory(begt.a);
      this.jdField_a_of_type_AndroidWidgetEditText.setOnClickListener(this);
      this.jdField_b_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)super.findViewById(2131364826));
      this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView = ((RecyclerView)super.findViewById(2131364811));
      this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView$LayoutManager = new GridLayoutManager(this, 3);
      this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setLayoutManager(this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView$LayoutManager);
      this.jdField_a_of_type_Bhls = new bhls(this, this);
      this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setAdapter(this.jdField_a_of_type_Bhls);
      this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.addOnScrollListener(this.jdField_a_of_type_Bhlv);
      this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)super.findViewById(2131364808));
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
      this.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)super.findViewById(2131364809));
      this.jdField_c_of_type_AndroidWidgetImageView.setOnClickListener(this);
      this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)super.findViewById(2131364812));
      this.jdField_b_of_type_AndroidWidgetImageView.setOnClickListener(this);
      this.jdField_c_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)super.findViewById(2131364813));
      this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)super.findViewById(2131364825));
      this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)super.findViewById(2131364823));
      this.jdField_d_of_type_AndroidWidgetTextView.setOnClickListener(this);
      this.jdField_d_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)super.findViewById(2131364818));
      this.jdField_d_of_type_AndroidWidgetImageView = ((ImageView)super.findViewById(2131364816));
      this.jdField_d_of_type_AndroidWidgetImageView.setOnClickListener(this);
      this.jdField_a_of_type_ComTencentMobileqqWidgetColorNickTextView = ((ColorNickTextView)super.findViewById(2131364819));
      this.jdField_e_of_type_AndroidWidgetTextView = ((TextView)super.findViewById(2131364817));
      this.jdField_e_of_type_AndroidWidgetTextView.setOnClickListener(this);
      d(false);
      a(0);
      localObject = this.app.getPreferences().getString("color_nick_last_edit", "");
      if (android.text.TextUtils.isEmpty((CharSequence)localObject))
      {
        this.jdField_d_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
        if ((this.jdField_a_of_type_AndroidWidgetEditText instanceof ColorClearableEditText)) {
          ((ColorClearableEditText)this.jdField_a_of_type_AndroidWidgetEditText).setTextClearedListener(this);
        }
        this.jdField_a_of_type_AndroidWidgetEditText.setFilters(new InputFilter[] { new adxb(this) });
        if (!arlu.c().isEnable()) {
          break label555;
        }
        e();
        this.jdField_c_of_type_AndroidWidgetImageView.setVisibility(8);
      }
    }
    label555:
    while ((!this.jdField_g_of_type_Boolean) || (!a(null)))
    {
      for (;;)
      {
        return;
        if (QLog.isColorLevel()) {
          QLog.d("ColorNick", 2, String.format("showing last nick and clear saved color nick.", new Object[0]));
        }
        this.jdField_d_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
        Object localObject = new begq((CharSequence)localObject, 16).a();
        this.jdField_a_of_type_ComTencentMobileqqWidgetColorNickTextView.setText((CharSequence)localObject);
        bhmb.a(this.app, this.jdField_a_of_type_ComTencentMobileqqWidgetColorNickTextView, (Spannable)localObject, this.jdField_c_of_type_Int, true);
        c(true);
      }
      this.jdField_c_of_type_AndroidWidgetImageView.setVisibility(0);
      return;
    }
    this.jdField_a_of_type_AndroidWidgetEditText.setText("");
  }
  
  public void delete()
  {
    com.tencent.mobileqq.text.TextUtils.backspace(this.jdField_a_of_type_AndroidWidgetEditText);
  }
  
  @Override
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, false, true);
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, bool, false);
    return bool;
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    j();
    c();
    paramBundle = findViewById(2131364821);
    if (paramBundle == null)
    {
      setContentBackgroundResource(2130838911);
      this.jdField_a_of_type_AndroidOsHandler.postDelayed(new EditInfoActivity.1(this), 500L);
      if (this.jdField_g_of_type_Boolean)
      {
        addObserver(this.jdField_a_of_type_Aofu);
        addObserver(this.jdField_a_of_type_Bhow);
      }
      if (this.jdField_h_of_type_Int != 1) {
        break label135;
      }
      addObserver(this.jdField_a_of_type_ComTencentMobileqqAppCardObserver);
    }
    for (;;)
    {
      if (!this.jdField_k_of_type_Boolean) {
        getWindow().setSoftInputMode(3);
      }
      return true;
      if (ThemeUtil.isInNightMode(this.app))
      {
        paramBundle.setVisibility(0);
        break;
      }
      paramBundle.setVisibility(8);
      break;
      label135:
      if (this.jdField_h_of_type_Int == 2) {
        addObserver(this.jdField_a_of_type_Anvi);
      }
    }
  }
  
  public void e()
  {
    this.jdField_a_of_type_ComTencentMobileqqVasTroopnickShopWidgetShopLayout = ((ShopLayout)findViewById(2131379643));
    if ((this.jdField_a_of_type_ComTencentMobileqqVasTroopnickShopWidgetShopLayout == null) || (android.text.TextUtils.isEmpty(this.jdField_e_of_type_JavaLangString))) {}
    do
    {
      return;
      this.jdField_a_of_type_ComTencentMobileqqVasTroopnickShopWidgetShopLayout.setHideInputmethod(new adwy(this));
      this.jdField_a_of_type_ComTencentMobileqqVasTroopnickShopWidgetShopLayout.a().a(new adwz(this));
      this.jdField_a_of_type_ComTencentMobileqqVasTroopnickShopWidgetShopLayout.setRequest(new bhtj(50, Long.parseLong(this.jdField_e_of_type_JavaLangString), this.jdField_a_of_type_ComTencentMobileqqVasTroopnickShopWidgetShopLayout.a()));
    } while (this.jdField_a_of_type_ComTencentMobileqqVasTroopnickShopWidgetShopLayout == null);
    this.jdField_a_of_type_ComTencentMobileqqVasTroopnickShopWidgetShopLayout.setShopCallback(new adxa(this));
    this.jdField_a_of_type_ComTencentMobileqqVasTroopnickShopWidgetShopLayout.setAppId(50);
  }
  
  public void emoticonMall() {}
  
  protected void f()
  {
    d();
    if ((this.jdField_a_of_type_AndroidWidgetEditText instanceof ClearableEditText))
    {
      this.jdField_a_of_type_AndroidWidgetEditText.setInputType(131072);
      ((ClearableEditText)this.jdField_a_of_type_AndroidWidgetEditText).setCanMultiLine(true);
      this.jdField_a_of_type_AndroidWidgetEditText.setSingleLine(false);
      adwd localadwd = new adwd(this);
      this.jdField_a_of_type_AndroidWidgetEditText.setFilters(new InputFilter[] { localadwd });
    }
  }
  
  protected void g()
  {
    super.setContentView(2131559154);
    this.jdField_a_of_type_ComTencentMobileqqWidgetInputMethodLinearLayout = ((InputMethodLinearLayout)super.findViewById(2131376947));
    this.jdField_a_of_type_ComTencentMobileqqWidgetInputMethodLinearLayout.setOnSizeChangedListenner(this);
    h();
    if (!this.jdField_i_of_type_Boolean)
    {
      this.jdField_a_of_type_AndroidWidgetEditText.getLayoutParams().height = ((int)bhdz.a(this, 149.0F));
      LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)this.jdField_a_of_type_ComTencentMobileqqWidgetInputMethodLinearLayout.findViewById(2131366005).getLayoutParams();
      localLayoutParams.height = ((int)bhdz.a(this, 151.0F));
      localLayoutParams.weight = 0.0F;
    }
    this.jdField_a_of_type_AndroidWidgetEditText.setEditableFactory(new adwe(this));
    if (this.jdField_f_of_type_Boolean) {
      i();
    }
  }
  
  protected void h()
  {
    this.jdField_a_of_type_AndroidWidgetEditText = ((EditText)super.findViewById(2131366023));
    this.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)super.findViewById(2131376947));
    if (!android.text.TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) {
      this.jdField_a_of_type_AndroidWidgetEditText.setContentDescription(this.jdField_a_of_type_JavaLangString);
    }
    if (!android.text.TextUtils.isEmpty(this.jdField_d_of_type_JavaLangString)) {
      this.jdField_a_of_type_AndroidWidgetEditText.setHint(this.jdField_d_of_type_JavaLangString);
    }
    if ((this.jdField_b_of_type_JavaLangString != null) && (this.jdField_b_of_type_JavaLangString.length() > 0)) {
      if (b()) {
        this.jdField_a_of_type_AndroidWidgetEditText.setText(this.jdField_b_of_type_JavaLangString);
      }
    }
    for (;;)
    {
      int n;
      try
      {
        if (this.jdField_g_of_type_Int == 0) {
          n = this.jdField_a_of_type_AndroidWidgetEditText.getText().toString().getBytes("utf-8").length;
        }
      }
      catch (UnsupportedEncodingException localUnsupportedEncodingException1)
      {
        n = 0;
      }
      label421:
      label444:
      try
      {
        this.jdField_c_of_type_JavaLangString = ("" + (this.jdField_d_of_type_Int - n));
        if ((this.jdField_c_of_type_Int > 0) && ((this.jdField_a_of_type_AndroidWidgetEditText instanceof ColorClearableEditText))) {
          ((ColorClearableEditText)this.jdField_a_of_type_AndroidWidgetEditText).setCustomCloth(this.jdField_c_of_type_Int, true);
        }
        if (this.jdField_e_of_type_Int == 3) {
          break label444;
        }
        if ((!this.jdField_e_of_type_Boolean) || (n > this.jdField_d_of_type_Int)) {
          break label421;
        }
        this.rightViewText.setEnabled(true);
        a(this.jdField_a_of_type_AndroidWidgetEditText);
        if (b()) {
          q();
        }
        if (!this.jdField_k_of_type_Boolean)
        {
          this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(4);
          this.jdField_a_of_type_AndroidWidgetEditText.clearFocus();
          this.jdField_a_of_type_AndroidWidgetEditText.setFocusable(false);
          this.jdField_a_of_type_AndroidWidgetEditText.setFocusableInTouchMode(false);
          this.jdField_a_of_type_AndroidWidgetEditText.setOnLongClickListener(new adwf(this));
          this.jdField_a_of_type_AndroidWidgetEditText.setLongClickable(false);
          this.jdField_a_of_type_AndroidWidgetEditText.setTextIsSelectable(false);
          this.jdField_a_of_type_AndroidWidgetEditText.setCustomSelectionActionModeCallback(new adwg(this));
        }
        return;
      }
      catch (UnsupportedEncodingException localUnsupportedEncodingException2)
      {
        label383:
        break label383;
      }
      if (this.jdField_g_of_type_Boolean)
      {
        this.jdField_a_of_type_AndroidWidgetEditText.setText(bhmb.b(this.jdField_b_of_type_JavaLangString));
      }
      else
      {
        this.jdField_a_of_type_AndroidWidgetEditText.setText(this.jdField_b_of_type_JavaLangString);
        continue;
        n = this.jdField_a_of_type_AndroidWidgetEditText.getText().toString().length();
        continue;
        localUnsupportedEncodingException1.printStackTrace();
        continue;
        this.jdField_c_of_type_JavaLangString = ("" + this.jdField_d_of_type_Int);
        n = 0;
        continue;
        if ((n == 0) || (n > this.jdField_d_of_type_Int))
        {
          this.rightViewText.setEnabled(false);
          continue;
          this.rightViewText.setEnabled(true);
        }
      }
    }
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      return true;
      if (this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel.mSecondTabInited = false;
        this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel.switchTabMode(0);
        continue;
        q();
        continue;
        if (QLog.isColorLevel()) {
          QLog.d("ColorNick", 2, String.format("MSG_TYPE_CLEAR_COLOR_NICK. saveColorNick", new Object[0]));
        }
        c(false);
        h();
        continue;
        bhmb.a(this.app).jdField_a_of_type_Bhmi.a(this.jdField_c_of_type_JavaUtilArrayList);
        if (this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel != null) {
          this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel.init(this.app, 100001, this, getTitleBarHeight(), null, null, false, bhmb.a(this.app).jdField_a_of_type_Bhmi);
        }
      }
    }
  }
  
  void i()
  {
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)super.findViewById(2131366091));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131378346));
    this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
    this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(new adwi(this));
    this.jdField_a_of_type_ComTencentMobileqqEmoticonviewSystemAndEmojiUniversalPanel = new SystemAndEmojiUniversalPanel.Builder(this).setFilterSysFaceBeyond255Enable(true).setEmoticonCallback(this).setShowDeleteButton(this.jdField_a_of_type_AndroidWidgetEditText).create();
    this.jdField_a_of_type_ComTencentMobileqqEmoticonviewSystemAndEmojiUniversalPanel.setVisibility(0);
    this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(this.jdField_a_of_type_ComTencentMobileqqEmoticonviewSystemAndEmojiUniversalPanel);
    this.jdField_a_of_type_AndroidWidgetEditText.setOnClickListener(new adwj(this));
  }
  
  public boolean isWrapContent()
  {
    return false;
  }
  
  protected void j()
  {
    Object localObject1 = getIntent();
    Object localObject2 = ((Intent)localObject1).getStringExtra("options");
    if (!android.text.TextUtils.isEmpty((CharSequence)localObject2)) {}
    for (;;)
    {
      try
      {
        localObject2 = new JSONObject((String)localObject2);
        this.jdField_a_of_type_JavaLangString = ((JSONObject)localObject2).optString("title");
        this.jdField_b_of_type_JavaLangString = ((JSONObject)localObject2).optString("defaultText");
        this.jdField_e_of_type_JavaLangString = ((JSONObject)localObject2).optString("gc");
        this.jdField_f_of_type_JavaLangString = ((JSONObject)localObject2).optString("uin");
        this.jdField_d_of_type_Int = ((JSONObject)localObject2).optInt("maxLength");
        this.jdField_e_of_type_Int = ((JSONObject)localObject2).optInt("src");
        this.jdField_h_of_type_JavaLangString = anvx.a(2131703117);
        this.jdField_g_of_type_JavaLangString = anvx.a(2131703114);
        this.jdField_g_of_type_Boolean = true;
        this.jdField_i_of_type_Int = 0;
        this.jdField_a_of_type_Int = ((Intent)localObject1).getIntExtra("edit_type", 0);
        this.jdField_b_of_type_Int = ((Intent)localObject1).getIntExtra("edit_subtype", -1);
        this.jdField_e_of_type_Boolean = ((Intent)localObject1).getBooleanExtra("canPostNull", true);
        this.jdField_f_of_type_Boolean = ((Intent)localObject1).getBooleanExtra("support_emotion", false);
        this.jdField_i_of_type_Boolean = ((Intent)localObject1).getBooleanExtra("full_screen", false);
        this.jdField_d_of_type_JavaLangString = ((Intent)localObject1).getStringExtra("default_hint");
        this.jdField_f_of_type_Int = ((Intent)localObject1).getIntExtra("send_type", 0);
        this.jdField_h_of_type_Int = ((Intent)localObject1).getIntExtra("edit_action", 0);
        this.jdField_g_of_type_JavaLangString = ((Intent)localObject1).getStringExtra("right_btn");
        this.jdField_g_of_type_Int = ((Intent)localObject1).getIntExtra("count_type", 0);
        this.jdField_h_of_type_JavaLangString = ((Intent)localObject1).getStringExtra("left_btn");
        this.jdField_i_of_type_JavaLangString = ((Intent)localObject1).getStringExtra("link_text");
        this.jdField_k_of_type_Boolean = ((Intent)localObject1).getBooleanExtra("edit_mode", true);
        this.jdField_c_of_type_Boolean = ((Intent)localObject1).getBooleanExtra("auto_remark", false);
        if ((this.jdField_c_of_type_Boolean) && (this.app != null) && (this.app.getCurrentAccountUin() != null) && (this.jdField_f_of_type_JavaLangString != null) && (!this.app.getCurrentAccountUin().equals(this.jdField_f_of_type_JavaLangString)) && (android.text.TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString)))
        {
          localObject1 = (aoep)this.app.getBusinessHandler(BusinessHandlerFactory.TROOP_HANDLER);
          if (localObject1 != null) {
            ((aoep)localObject1).x(this.jdField_f_of_type_JavaLangString);
          }
          this.jdField_d_of_type_Boolean = true;
        }
        return;
      }
      catch (JSONException localJSONException)
      {
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.e(".troop.memberCard", 2, "EditInfoActivity.initData optionArgs parse error.", localJSONException);
        continue;
      }
      this.jdField_a_of_type_JavaLangString = ((Intent)localObject1).getStringExtra("title");
      this.jdField_b_of_type_JavaLangString = ((Intent)localObject1).getStringExtra("default_text");
      this.jdField_c_of_type_Int = ((Intent)localObject1).getIntExtra("default_nick_id", 0);
      this.jdField_e_of_type_JavaLangString = ((Intent)localObject1).getStringExtra("troopUin");
      this.jdField_f_of_type_JavaLangString = ((Intent)localObject1).getStringExtra("uin");
      this.jdField_d_of_type_Int = ((Intent)localObject1).getIntExtra("max_num", 0);
      this.jdField_e_of_type_Int = ((Intent)localObject1).getIntExtra("from", -1);
      this.jdField_g_of_type_Boolean = ((Intent)localObject1).getBooleanExtra("isTroopNick", false);
      this.jdField_h_of_type_Boolean = ((Intent)localObject1).getBooleanExtra("isTroopName", false);
      this.jdField_i_of_type_Int = ((Intent)localObject1).getIntExtra("max_limit_mode", 0);
    }
  }
  
  public void k()
  {
    if ((this.jdField_a_of_type_AndroidWidgetEditText instanceof ColorClearableEditText))
    {
      ColorClearableEditText localColorClearableEditText = (ColorClearableEditText)this.jdField_a_of_type_AndroidWidgetEditText;
      localColorClearableEditText.setSpecialColor(0, null, null, 0, null);
      localColorClearableEditText.setCustomCloth(0);
    }
    for (;;)
    {
      this.jdField_a_of_type_Bhls.a(-1);
      this.jdField_a_of_type_Bhls.a.a(-1);
      return;
      this.jdField_a_of_type_AndroidWidgetEditText.setTextColor(getResources().getColor(2131167125));
    }
  }
  
  public void l() {}
  
  public void m() {}
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (paramInt1 == 1) {
      p();
    }
  }
  
  public boolean onBackEvent()
  {
    VasWebviewUtil.reportCommercialDrainage(this.app.getCurrentUin(), "group_nickname", "group_nickname_8", "", 1, 0, 0, "", "", "");
    b();
    if (QLog.isColorLevel()) {
      QLog.d("ColorNick", 2, "onBackEvent. save colorNick");
    }
    c(false);
    return super.onBackEvent();
  }
  
  public void onClick(View paramView)
  {
    int n = 0;
    switch (paramView.getId())
    {
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      Object localObject = "1";
      if (this.jdField_l_of_type_Int == 2) {
        localObject = "2";
      }
      if (this.jdField_l_of_type_Boolean)
      {
        this.jdField_j_of_type_Int = 2;
        b();
      }
      for (;;)
      {
        VasWebviewUtil.reportCommercialDrainage(this.app.getCurrentUin(), "group_nickname", "group_nickname_6", "", 1, 0, 0, "", (String)localObject, "");
        break;
        b(2);
      }
      localObject = "1";
      if (this.jdField_l_of_type_Int == 1) {
        localObject = "2";
      }
      if (this.jdField_l_of_type_Boolean)
      {
        this.jdField_j_of_type_Int = 1;
        b();
      }
      for (;;)
      {
        VasWebviewUtil.reportCommercialDrainage(this.app.getCurrentUin(), "group_nickname", "group_nickname_5", "", 1, 0, 0, "", (String)localObject, "");
        break;
        b(1);
      }
      bhoy.a(this, "mvip.g.a.qnc_kt", "CJCLUBT", -1, false, true);
      VasWebviewUtil.reportCommercialDrainage(this.app.getCurrentUin(), "group_nickname", "group_nickname_3", "", 1, 0, 0, "", "", "");
      continue;
      this.jdField_d_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
      continue;
      localObject = new begq(this.jdField_a_of_type_ComTencentMobileqqWidgetColorNickTextView.getText().toString(), 32).a();
      this.jdField_a_of_type_AndroidWidgetEditText.setText((CharSequence)localObject);
      bhmb.a(this.app, this.jdField_a_of_type_AndroidWidgetEditText, (Spannable)localObject);
      this.jdField_d_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
      continue;
      if ((this.jdField_k_of_type_Boolean) || (!this.jdField_h_of_type_Boolean)) {
        continue;
      }
      if (!android.text.TextUtils.isEmpty(this.jdField_e_of_type_JavaLangString)) {
        n = 1;
      }
      if (n != 0) {}
      try
      {
        for (localObject = String.format(getString(2131719709), new Object[] { this.jdField_b_of_type_JavaLangString, this.jdField_e_of_type_JavaLangString }); !android.text.TextUtils.isEmpty((CharSequence)localObject); localObject = String.format(getString(2131719710), new Object[] { this.jdField_b_of_type_JavaLangString }))
        {
          if (Build.VERSION.SDK_INT >= 11) {
            break label461;
          }
          ((android.text.ClipboardManager)getSystemService("clipboard")).setText((CharSequence)localObject);
          QQToast.a(this, 2131699014, 1).a();
          break;
        }
      }
      catch (Exception localException)
      {
        for (;;)
        {
          localException.printStackTrace();
          String str = "";
          continue;
          label461:
          ((android.content.ClipboardManager)getSystemService("clipboard")).setText(str);
        }
      }
    }
  }
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    if (this.jdField_g_of_type_Boolean)
    {
      removeObserver(this.jdField_a_of_type_Aofu);
      removeObserver(this.jdField_a_of_type_Bhow);
    }
    if (this.jdField_a_of_type_AndroidOsHandler != null) {
      this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqEmoticonviewSystemAndEmojiUniversalPanel != null) {
      this.jdField_a_of_type_ComTencentMobileqqEmoticonviewSystemAndEmojiUniversalPanel.onDestory();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel != null) {
      this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel.onDestory();
    }
    this.app.removeObserver(this.jdField_a_of_type_Aodb);
    bhmb.a(this.app).jdField_a_of_type_AndroidOsHandler = null;
    try
    {
      this.jdField_a_of_type_AndroidWidgetEditText.setFocusable(false);
      this.jdField_a_of_type_AndroidWidgetEditText.setFocusableInTouchMode(false);
      this.jdField_a_of_type_AndroidWidgetEditText.setVisibility(8);
      this.jdField_a_of_type_AndroidViewViewGroup.removeView(this.jdField_a_of_type_AndroidWidgetEditText);
      removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppCardObserver);
      removeObserver(this.jdField_a_of_type_Anvi);
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.e("EditInfoActivity", 2, "onDestroy" + localException.toString());
        }
      }
    }
  }
  
  public void onHidePopup(EmoticonInfo paramEmoticonInfo) {}
  
  public boolean onLongClick(EmoticonInfo paramEmoticonInfo)
  {
    return false;
  }
  
  public void onPause()
  {
    b();
    super.onPause();
  }
  
  public void onResume()
  {
    if (this.jdField_k_of_type_Boolean) {
      a();
    }
    for (;;)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqVasTroopnickShopWidgetShopLayout != null) {
        this.jdField_a_of_type_ComTencentMobileqqVasTroopnickShopWidgetShopLayout.b();
      }
      super.onResume();
      return;
      b();
    }
  }
  
  public void onShowPopup(EmoticonInfo paramEmoticonInfo1, EmoticonInfo paramEmoticonInfo2, Drawable paramDrawable) {}
  
  public void send() {}
  
  public void send(EmoticonInfo paramEmoticonInfo)
  {
    if ((this.jdField_a_of_type_AndroidWidgetEditText instanceof ColorClearableEditText))
    {
      this.m = true;
      if ((paramEmoticonInfo instanceof SystemAndEmojiEmoticonInfo))
      {
        paramEmoticonInfo = (SystemAndEmojiEmoticonInfo)paramEmoticonInfo;
        if (paramEmoticonInfo.code != -1) {}
      }
      while (!(paramEmoticonInfo instanceof SmallEmoticonInfo))
      {
        return;
        int n = this.jdField_a_of_type_AndroidWidgetEditText.getSelectionStart();
        int i1 = this.jdField_a_of_type_AndroidWidgetEditText.getSelectionEnd();
        this.jdField_a_of_type_AndroidWidgetEditText.getEditableText().replace(n, i1, com.tencent.mobileqq.text.TextUtils.getColorNickSysEmoticonString(paramEmoticonInfo.code));
        this.jdField_a_of_type_AndroidWidgetEditText.requestFocus();
        return;
      }
      bhmb.a((SmallEmoticonInfo)paramEmoticonInfo, this.app, this.jdField_a_of_type_AndroidWidgetEditText);
      return;
    }
    paramEmoticonInfo.send(this.app, this, this.jdField_a_of_type_AndroidWidgetEditText, null);
  }
  
  public void setting() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.EditInfoActivity
 * JD-Core Version:    0.7.0.1
 */