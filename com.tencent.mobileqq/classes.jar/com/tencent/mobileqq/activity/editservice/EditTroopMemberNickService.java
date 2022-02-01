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
  IEmoticonMainPanel A;
  SoftInputDetectView B;
  RelativeLayout C;
  ColorNickTextView D;
  TextView E;
  ImageView F;
  LinearLayout G;
  PresetWordFlowLayout H;
  TextView I;
  ImageView J;
  ShopLayout K;
  protected Handler L = new Handler(this);
  TroopObserver M = new EditTroopMemberNickService.7(this);
  ColorNickColorPanelAdapter.OnColorSelectListener N = new EditTroopMemberNickService.8(this);
  SoftInputDetectView.OnImStateChangedListener O = new EditTroopMemberNickService.9(this);
  ClearableEditText.OnTextClearedListener P = new EditTroopMemberNickService.10(this);
  private QQAppInterface Q;
  private Context R;
  private IEditInfoActivity S;
  private View T;
  private boolean U = false;
  private int V = 0;
  private ColorNickColorPanelAdapter.ColorItem[] W = { new ColorNickColorPanelAdapter.ColorItem(2, null, 0, null) };
  private boolean X = false;
  private int Y = 0;
  private ArrayList<ColorNickColorPanelAdapter.ColorItem> Z = new ArrayList();
  protected EditText a = null;
  private ArrayList<Integer> aa = new ArrayList();
  private int ab = 0;
  private final SVIPObserver ac = new EditTroopMemberNickService.11(this);
  private final IApolloExtensionObserver ad = new EditTroopMemberNickService.12(this);
  private final ColorNickColorPanelAdapter.EndlessRecyclerOnScrollListener ae = new EditTroopMemberNickService.13(this);
  protected boolean b = false;
  protected boolean c = false;
  TextView d = null;
  protected int e = -1;
  protected String f = null;
  protected String g = null;
  protected int h = 0;
  protected int i = -1;
  String j;
  String k;
  int l = 0;
  boolean m;
  protected PresetWordsListAdapter n;
  protected ArrayList<String> o = new ArrayList();
  protected String p;
  RelativeLayout q;
  TextView r;
  TextView s;
  ImageView t;
  ImageView u;
  RelativeLayout v;
  RelativeLayout w;
  RecyclerView x;
  RecyclerView.LayoutManager y;
  ColorNickColorPanelAdapter z;
  
  /* Error */
  private boolean a(EditTroopMemberNickService.NickInfo paramNickInfo)
  {
    // Byte code:
    //   0: aload_1
    //   1: ifnull +18 -> 19
    //   4: aload_1
    //   5: iconst_0
    //   6: putfield 206	com/tencent/mobileqq/activity/editservice/EditTroopMemberNickService$NickInfo:b	Z
    //   9: aload_1
    //   10: iconst_0
    //   11: putfield 208	com/tencent/mobileqq/activity/editservice/EditTroopMemberNickService$NickInfo:a	Z
    //   14: aload_1
    //   15: iconst_0
    //   16: putfield 209	com/tencent/mobileqq/activity/editservice/EditTroopMemberNickService$NickInfo:c	Z
    //   19: aload_0
    //   20: getfield 107	com/tencent/mobileqq/activity/editservice/EditTroopMemberNickService:a	Landroid/widget/EditText;
    //   23: astore 7
    //   25: aload 7
    //   27: instanceof 211
    //   30: ifeq +249 -> 279
    //   33: aload 7
    //   35: checkcast 211	com/tencent/mobileqq/widget/ColorClearableEditText
    //   38: astore 7
    //   40: aload 7
    //   42: invokevirtual 215	com/tencent/mobileqq/widget/ColorClearableEditText:getScid	()I
    //   45: ifle +14 -> 59
    //   48: aload_1
    //   49: ifnull +10 -> 59
    //   52: aload_1
    //   53: iconst_1
    //   54: putfield 209	com/tencent/mobileqq/activity/editservice/EditTroopMemberNickService$NickInfo:c	Z
    //   57: iconst_1
    //   58: ireturn
    //   59: aload 7
    //   61: invokevirtual 217	com/tencent/mobileqq/widget/ColorClearableEditText:a	()V
    //   64: aload 7
    //   66: invokevirtual 221	com/tencent/mobileqq/widget/ColorClearableEditText:getParagraphs	()Ljava/util/ArrayList;
    //   69: astore 7
    //   71: aload 7
    //   73: ifnull +206 -> 279
    //   76: aload 7
    //   78: invokevirtual 224	java/util/ArrayList:size	()I
    //   81: ifle +198 -> 279
    //   84: aload 7
    //   86: invokevirtual 228	java/util/ArrayList:iterator	()Ljava/util/Iterator;
    //   89: astore 7
    //   91: iconst_0
    //   92: istore 4
    //   94: iconst_0
    //   95: istore_3
    //   96: aload 7
    //   98: invokeinterface 234 1 0
    //   103: ifeq +129 -> 232
    //   106: aload 7
    //   108: invokeinterface 238 1 0
    //   113: checkcast 240	com/tencent/mobileqq/widget/ColorClearableEditText$Paragraph
    //   116: astore 8
    //   118: aload 8
    //   120: getfield 241	com/tencent/mobileqq/widget/ColorClearableEditText$Paragraph:e	I
    //   123: iconst_1
    //   124: if_icmpne +13 -> 137
    //   127: iconst_1
    //   128: istore 6
    //   130: iload 4
    //   132: istore 5
    //   134: goto +56 -> 190
    //   137: aload 8
    //   139: getfield 241	com/tencent/mobileqq/widget/ColorClearableEditText$Paragraph:e	I
    //   142: iconst_3
    //   143: if_icmpne +12 -> 155
    //   146: iconst_1
    //   147: istore 5
    //   149: iload_3
    //   150: istore 6
    //   152: goto +38 -> 190
    //   155: aload 8
    //   157: getfield 241	com/tencent/mobileqq/widget/ColorClearableEditText$Paragraph:e	I
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
    //   180: putfield 206	com/tencent/mobileqq/activity/editservice/EditTroopMemberNickService$NickInfo:b	Z
    //   183: aload_1
    //   184: iload_3
    //   185: putfield 208	com/tencent/mobileqq/activity/editservice/EditTroopMemberNickService$NickInfo:a	Z
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
    //   221: putfield 206	com/tencent/mobileqq/activity/editservice/EditTroopMemberNickService$NickInfo:b	Z
    //   224: aload_1
    //   225: iload 6
    //   227: putfield 208	com/tencent/mobileqq/activity/editservice/EditTroopMemberNickService$NickInfo:a	Z
    //   230: iconst_1
    //   231: ireturn
    //   232: aload_1
    //   233: ifnull +46 -> 279
    //   236: aload_1
    //   237: iload 4
    //   239: putfield 206	com/tencent/mobileqq/activity/editservice/EditTroopMemberNickService$NickInfo:b	Z
    //   242: aload_1
    //   243: iload_3
    //   244: putfield 208	com/tencent/mobileqq/activity/editservice/EditTroopMemberNickService$NickInfo:a	Z
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
    //   268: putfield 206	com/tencent/mobileqq/activity/editservice/EditTroopMemberNickService$NickInfo:b	Z
    //   271: aload_1
    //   272: iload_3
    //   273: putfield 208	com/tencent/mobileqq/activity/editservice/EditTroopMemberNickService$NickInfo:a	Z
    //   276: aload 7
    //   278: athrow
    //   279: iconst_0
    //   280: ireturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	281	0	this	EditTroopMemberNickService
    //   0	281	1	paramNickInfo	EditTroopMemberNickService.NickInfo
    //   160	11	2	i1	int
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
  
  private void b(int paramInt)
  {
    this.Q.addObserver(this.ac);
    ((SVIPHandler)this.Q.getBusinessHandler(BusinessHandlerFactory.SVIP_HANDLER)).e(paramInt);
  }
  
  private void b(boolean paramBoolean)
  {
    Object localObject = new ArrayList();
    Collections.addAll((Collection)localObject, this.W);
    ((ArrayList)localObject).addAll(this.Z);
    this.z.a((List)localObject, paramBoolean);
    localObject = ((FriendsManager)this.Q.getManager(QQManagerFactory.FRIENDS_MANAGER)).m(this.k);
    if (localObject != null)
    {
      if (((Friends)localObject).isServiceEnabled(EVIPSPEC.E_SP_SUPERVIP))
      {
        this.r.setText(d(2131887827));
        this.s.setText(d(2131887828));
        return;
      }
      this.r.setText(d(2131887825));
      this.s.setText(d(2131887826));
    }
  }
  
  private void c(int paramInt)
  {
    if (paramInt != 1)
    {
      if (paramInt == 2) {
        if (this.ab == 2)
        {
          this.S.showInputMethod();
        }
        else
        {
          this.ab = 2;
          this.C.setVisibility(8);
          ColorNickManager.a(this.Q).c = this.L;
          this.u.setImageResource(2130848953);
          this.t.setImageResource(2130848960);
          this.v.setVisibility(0);
          this.w.setVisibility(8);
          this.x.setVisibility(0);
          ((RelativeLayout.LayoutParams)this.v.getLayoutParams()).height = DisplayUtil.a(this.R, 388.0F);
          ((RelativeLayout.LayoutParams)this.q.getLayoutParams()).bottomMargin = DisplayUtil.a(this.R, 388.0F);
        }
      }
    }
    else if (this.ab == 1)
    {
      this.S.showInputMethod();
    }
    else
    {
      this.ab = 1;
      this.C.setVisibility(8);
      ColorNickManager.a(this.Q).c = this.L;
      this.u.setImageResource(2130848954);
      this.t.setImageResource(2130848959);
      this.v.setVisibility(0);
      this.w.setVisibility(0);
      this.x.setVisibility(8);
      ((RelativeLayout.LayoutParams)this.v.getLayoutParams()).height = DisplayUtil.a(this.R, 387.0F);
      ((RelativeLayout.LayoutParams)this.q.getLayoutParams()).bottomMargin = DisplayUtil.a(this.R, 387.0F);
      if (this.A == null)
      {
        IEmoticonMainPanelService.PanelBuilder localPanelBuilder = ((IEmoticonMainPanelService)this.Q.getRuntimeService(IEmoticonMainPanelService.class)).newBuilder(this.R, 100001);
        boolean bool;
        if (this.i == 0) {
          bool = true;
        } else {
          bool = false;
        }
        this.A = localPanelBuilder.setFilterSysFaceBeyond255Enable(bool).setCallBack(this).setDisableGuide(true).setDisableMoreEmotionButton(true).setHasBigEmotion(false).setOnlySysAndEmoji(true).setDisableAutoDownload(true).setToastOffset(v()).setEmoticonListProvider(ColorNickManager.a(this.Q).b).create();
        this.A.setTabListOverScrollMode(2);
        this.w.addView(this.A.getView());
      }
    }
    this.V = 0;
  }
  
  private String d(int paramInt)
  {
    return HardCodeUtil.a(paramInt);
  }
  
  private <T extends View> T e(int paramInt)
  {
    View localView = this.T;
    if (localView != null) {
      return localView.findViewById(paramInt);
    }
    return null;
  }
  
  private void m()
  {
    if (QLog.isColorLevel()) {
      QLog.d("EditTroopMemberNickService", 2, "initGetTroopNickRule EditMode isTroopNick");
    }
    this.G = ((LinearLayout)e(2131448058));
    Object localObject = this.G;
    if (localObject == null) {
      return;
    }
    ((LinearLayout)localObject).setVerticalScrollBarEnabled(false);
    this.d = this.S.getTipsView();
    localObject = this.d;
    if (localObject == null) {
      return;
    }
    ((TextView)localObject).setOnClickListener(new EditTroopMemberNickService.1(this));
    this.I = ((TextView)e(2131448057));
    this.J = ((ImageView)e(2131448055));
    this.J.setOnClickListener(new EditTroopMemberNickService.2(this));
    if (ThemeUtil.isInNightMode(this.Q)) {
      this.J.setBackgroundDrawable(w().getDrawable(2130847845));
    }
    this.H = ((PresetWordFlowLayout)e(2131448059));
    this.H.c = ViewUtils.dpToPx(12.0F);
    this.H.e = ViewUtils.dpToPx(12.0F);
    this.n = new PresetWordsListAdapter();
    if (ThemeUtil.isInNightMode(this.Q)) {
      this.n.c();
    }
    this.n.d();
    this.n.c = new EditTroopMemberNickService.3(this);
    this.H.setAdapter(this.n);
    o();
  }
  
  private void n()
  {
    Object localObject = ((ITroopInfoService)this.Q.getRuntimeService(ITroopInfoService.class, "")).findTroopInfo(this.j);
    if (localObject != null)
    {
      Intent localIntent = new Intent();
      localIntent.putExtra(TroopNickRuleFragment.a, this.j);
      localIntent.putExtra(TroopNickRuleFragment.b, ((TroopInfo)localObject).groupCardPrefixIntro);
      if (this.i == 0) {
        localIntent.putExtra(TroopNickRuleFragment.d, "1");
      } else {
        localIntent.putExtra(TroopNickRuleFragment.d, "3");
      }
      localObject = ((TroopInfo)localObject).getGroupCardPrefix();
      if (localObject != null) {
        localIntent.putStringArrayListExtra(TroopNickRuleFragment.c, (ArrayList)localObject);
      }
      PublicFragmentActivity.Launcher.a(this.R, localIntent, PublicFragmentActivity.class, TroopNickRuleFragment.class, 1);
    }
  }
  
  private void o()
  {
    Object localObject1 = ((ITroopInfoService)this.Q.getRuntimeService(ITroopInfoService.class, "")).findTroopInfo(this.j);
    if (localObject1 != null)
    {
      this.o = ((TroopInfo)localObject1).getGroupCardPrefix();
      Object localObject2 = this.H;
      int i3 = 8;
      int i1;
      if (localObject2 != null)
      {
        if (this.o.isEmpty()) {
          i1 = 8;
        } else {
          i1 = 0;
        }
        ((PresetWordFlowLayout)localObject2).setVisibility(i1);
        t();
      }
      this.p = ((TroopInfo)localObject1).groupCardPrefixIntro;
      localObject2 = this.I;
      if (localObject2 != null)
      {
        if (android.text.TextUtils.isEmpty(this.p)) {
          i1 = 8;
        } else {
          i1 = 0;
        }
        ((TextView)localObject2).setVisibility(i1);
        this.I.setText(this.p);
      }
      if ((this.o.isEmpty()) && (android.text.TextUtils.isEmpty(this.p))) {
        i1 = 0;
      } else {
        i1 = 1;
      }
      localObject2 = this.G;
      int i2;
      if (localObject2 != null)
      {
        if (i1 != 0) {
          i2 = 0;
        } else {
          i2 = 8;
        }
        ((LinearLayout)localObject2).setVisibility(i2);
      }
      boolean bool = ((TroopInfo)localObject1).isOwnerOrAdmin(this.Q.getCurrentAccountUin());
      localObject1 = this.J;
      if (localObject1 != null)
      {
        if ((i1 != 0) && (bool)) {
          i2 = 0;
        } else {
          i2 = 8;
        }
        ((ImageView)localObject1).setVisibility(i2);
      }
      localObject1 = this.d;
      if (localObject1 != null)
      {
        i2 = i3;
        if (i1 == 0)
        {
          i2 = i3;
          if (bool) {
            i2 = 0;
          }
        }
        ((TextView)localObject1).setVisibility(i2);
      }
    }
  }
  
  private void p()
  {
    SpannableString localSpannableString = new ColorNickText(this.a.getText().toString(), 16).b();
    ColorNickManager.a(this.Q, this.a, localSpannableString, this.h, true);
  }
  
  private boolean q()
  {
    return this.k.equals(this.Q.getCurrentAccountUin());
  }
  
  private boolean r()
  {
    QVipColorNickConfig localQVipColorNickConfig = QVipColorNickProcessor.e();
    if (localQVipColorNickConfig == null) {
      return q();
    }
    return (localQVipColorNickConfig.a) && (q());
  }
  
  private int s()
  {
    Object localObject2;
    if (a(new EditTroopMemberNickService.NickInfo()))
    {
      localObject1 = ((ColorClearableEditText)this.a).getParagraphs();
      ArrayList localArrayList = new ArrayList();
      Iterator localIterator = ((ArrayList)localObject1).iterator();
      while (localIterator.hasNext())
      {
        localObject1 = (ColorClearableEditText.Paragraph)localIterator.next();
        Oidb_0x8fc.RichCardNameElem localRichCardNameElem = new Oidb_0x8fc.RichCardNameElem();
        i1 = ((ColorClearableEditText.Paragraph)localObject1).e;
        if (i1 != 1)
        {
          if ((i1 == 2) || (i1 == 3))
          {
            localObject2 = ((ColorClearableEditText.Paragraph)localObject1).c;
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
          localRichCardNameElem.bytes_text.set(ByteStringMicro.copyFrom(this.a.getText().toString().getBytes()));
        }
        localArrayList.add(localRichCardNameElem);
      }
      localObject1 = new Oidb_0x8fc.CommCardNameBuf();
      ((Oidb_0x8fc.CommCardNameBuf)localObject1).rpt_rich_card_name.set(localArrayList);
      return ((Oidb_0x8fc.CommCardNameBuf)localObject1).toByteArray().length + 3;
    }
    Object localObject1 = this.a.getText();
    if (localObject1 == null) {
      localObject1 = "";
    } else {
      localObject1 = localObject1.toString();
    }
    int i1 = ((String)localObject1).trim().length();
    try
    {
      int i2 = ((String)localObject1).getBytes("utf-8").length;
      return i2;
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
    return i1;
  }
  
  private void t()
  {
    Object localObject = this.n;
    if (localObject != null)
    {
      ((PresetWordsListAdapter)localObject).a();
      localObject = this.o.iterator();
      while (((Iterator)localObject).hasNext())
      {
        String str = (String)((Iterator)localObject).next();
        this.n.a(str);
      }
      localObject = this.H;
      int i1;
      if (this.n.getCount() == 0) {
        i1 = 8;
      } else {
        i1 = 0;
      }
      ((PresetWordFlowLayout)localObject).setVisibility(i1);
      this.n.notifyDataSetChanged();
    }
  }
  
  private void u()
  {
    Object localObject1 = this.a.getText();
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
    VasWebviewUtil.a(this.Q.getCurrentUin(), "group_nickname", "group_nickname_7", "", 1, 0, 0, "", "", "");
    if (!NetworkUtil.isNetSupport(this.Q.getApplication().getApplicationContext()))
    {
      QQToast.makeText(this.R, 1, 2131892104, 0).show(v());
      ReportController.b(this.Q, "dc00899", "Grp_set", "", "nickname edit", "nickname edit_sub_failure", 0, 0, String.valueOf(this.j), "1", "", "");
      return;
    }
    Object localObject3 = localObject1;
    if (q())
    {
      localObject4 = new EditTroopMemberNickService.NickInfo();
      if (a((EditTroopMemberNickService.NickInfo)localObject4))
      {
        if ((((EditTroopMemberNickService.NickInfo)localObject4).c) && (this.a.getText().length() <= 0))
        {
          QQToast.makeText(this.R, HardCodeUtil.a(2131901728), 0).show(v());
          return;
        }
        this.S.loadingProgress(true);
        i1 = ((ColorClearableEditText)this.a).getScid();
        if (i1 > 0)
        {
          localObject1 = new EditTroopMemberNickService.15(this, i1);
          new TroopNickAuthRequest().a(50, i1, 6, (AuthRequest.AuthListener)localObject1);
          this.m = true;
          return;
        }
        ((IApolloExtensionHandler)this.Q.getBusinessHandler(BusinessHandlerFactory.APOLLO_EXTENSION_HANDLER)).a(this.j, ((ColorClearableEditText)this.a).getParagraphs(), i1);
        this.m = true;
        return;
      }
      localObject3 = localObject1;
      if (((EditTroopMemberNickService.NickInfo)localObject4).b)
      {
        localObject3 = localObject1;
        if (!((EditTroopMemberNickService.NickInfo)localObject4).a) {
          localObject3 = "";
        }
      }
    }
    int i1 = this.l;
    if (((i1 == 3) || (i1 == 4)) && (android.text.TextUtils.isEmpty((CharSequence)localObject3)) && (!android.text.TextUtils.isEmpty((CharSequence)localObject2)))
    {
      QQToast.makeText(this.R, d(2131890848), 0).show(v());
      return;
    }
    i1 = ((ColorClearableEditText)this.a).getScid();
    if (((android.text.TextUtils.isEmpty(this.g)) && (android.text.TextUtils.isEmpty((CharSequence)localObject3))) || ((!android.text.TextUtils.isEmpty(this.g)) && (this.g.equals(localObject3)) && (this.h == i1)))
    {
      this.S.onFinish();
      return;
    }
    Object localObject2 = new TroopMemberCardInfo();
    ((TroopMemberCardInfo)localObject2).name = ((String)localObject3);
    ((TroopMemberCardInfo)localObject2).memberuin = this.k;
    ((TroopMemberCardInfo)localObject2).troopuin = this.j;
    ((TroopMemberCardInfo)localObject2).email = "";
    ((TroopMemberCardInfo)localObject2).memo = "";
    ((TroopMemberCardInfo)localObject2).sex = -1;
    ((TroopMemberCardInfo)localObject2).tel = "";
    localObject1 = new ArrayList();
    ((ArrayList)localObject1).add(localObject2);
    localObject2 = new ArrayList();
    ((ArrayList)localObject2).add(Integer.valueOf(1));
    localObject3 = (ITroopMemberCardHandler)this.Q.getBusinessHandler(BusinessHandlerFactory.TROOP_MEMBER_CARD_HANDLER);
    if ((localObject3 != null) && (!android.text.TextUtils.isEmpty(this.j)))
    {
      this.S.loadingProgress(true);
      ((ITroopMemberCardHandler)localObject3).a(this.j, (ArrayList)localObject1, (ArrayList)localObject2);
    }
    int i2 = 2;
    localObject1 = ((ITroopInfoService)this.Q.getRuntimeService(ITroopInfoService.class, "")).findTroopInfo(this.j);
    i1 = i2;
    if (localObject1 != null) {
      if ((!android.text.TextUtils.isEmpty(((TroopInfo)localObject1).troopowneruin)) && (((TroopInfo)localObject1).troopowneruin.equalsIgnoreCase(this.Q.getAccount())))
      {
        i1 = 0;
      }
      else
      {
        i1 = i2;
        if (!android.text.TextUtils.isEmpty(((TroopInfo)localObject1).Administrator))
        {
          i1 = i2;
          if (((TroopInfo)localObject1).Administrator.contains(this.Q.getAccount())) {
            i1 = 1;
          }
        }
      }
    }
    this.m = true;
    localObject1 = this.Q;
    localObject2 = this.j;
    localObject3 = new StringBuilder();
    ((StringBuilder)localObject3).append(i1);
    ((StringBuilder)localObject3).append("");
    localObject3 = ((StringBuilder)localObject3).toString();
    Object localObject4 = new StringBuilder();
    ((StringBuilder)localObject4).append("");
    ((StringBuilder)localObject4).append(this.i);
    ReportController.b((AppRuntime)localObject1, "P_CliOper", "Grp_manage", "", "modify_name", "complete", 0, 0, (String)localObject2, (String)localObject3, ((StringBuilder)localObject4).toString(), "");
  }
  
  private int v()
  {
    return w().getDimensionPixelSize(2131299920);
  }
  
  private Resources w()
  {
    return this.R.getResources();
  }
  
  public Intent a(Intent paramIntent)
  {
    paramIntent.putExtra("count_type", 2);
    this.g = paramIntent.getStringExtra("default_text");
    this.h = paramIntent.getIntExtra("default_nick_id", 0);
    this.j = paramIntent.getStringExtra("troopUin");
    this.k = paramIntent.getStringExtra("uin");
    this.i = paramIntent.getIntExtra("from", -1);
    this.l = paramIntent.getIntExtra("edit_action", 0);
    this.b = paramIntent.getBooleanExtra("auto_remark", false);
    if (this.b)
    {
      Object localObject = this.Q;
      if ((localObject != null) && (((QQAppInterface)localObject).getCurrentAccountUin() != null) && (this.k != null) && (!this.Q.getCurrentAccountUin().equals(this.k)) && (android.text.TextUtils.isEmpty(this.g)))
      {
        localObject = (ITroopMemberInfoHandler)this.Q.getBusinessHandler(BusinessHandlerFactory.TROOP_MEMBER_INFO_HANDLER);
        if (localObject != null) {
          ((ITroopMemberInfoHandler)localObject).a(this.k);
        }
        this.c = true;
      }
    }
    return paramIntent;
  }
  
  protected void a()
  {
    VasWebviewUtil.a(this.Q.getCurrentUin(), "group_nickname", "group_nickname_8", "", 1, 0, 0, "", "", "");
    if (QLog.isColorLevel()) {
      QLog.d("ColorNick", 2, "onBackEvent. save colorNick");
    }
    a(false);
    this.S.onFinish();
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
        l();
        return;
      }
      k();
      return;
    }
    j();
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (paramInt1 == 1) {
      o();
    }
  }
  
  public void a(ViewGroup paramViewGroup1, EditText paramEditText, ViewGroup paramViewGroup2)
  {
    this.T = paramViewGroup1;
    this.a = paramEditText;
    paramViewGroup1 = LayoutInflater.from(this.R);
    try
    {
      paramViewGroup1.inflate(2131629598, paramViewGroup2, true);
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
    g();
  }
  
  public void a(IEditInfoActivity paramIEditInfoActivity)
  {
    this.Q = ((QQAppInterface)MobileQQ.sMobileQQ.waitAppRuntime(null));
    this.S = paramIEditInfoActivity;
    this.R = paramIEditInfoActivity.getContext();
    this.Q.addObserver(this.M);
    this.Q.addObserver(this.ad);
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
      this.Q.getPreferences().edit().putString("color_nick_last_edit", "").commit();
    }
    if ((!paramBoolean) && (a(null)) && (this.X) && (!this.a.getText().toString().equals(this.g)))
    {
      if (QLog.isColorLevel()) {
        QLog.d("ColorNick", 2, "saveColorNick. save currentText!");
      }
      this.Q.getPreferences().edit().putString("color_nick_last_edit", this.a.getText().toString()).commit();
    }
  }
  
  public OnItemSelectListener b()
  {
    return new EditTroopMemberNickService.14(this);
  }
  
  public void c()
  {
    EditText localEditText = this.a;
    if ((localEditText instanceof ColorClearableEditText)) {
      ((ColorClearableEditText)localEditText).b();
    }
  }
  
  public int d()
  {
    return s();
  }
  
  public void delete()
  {
    com.tencent.mobileqq.text.TextUtils.backspace(this.a);
  }
  
  public View.OnClickListener e()
  {
    return null;
  }
  
  public void emoticonMall() {}
  
  public EmoticonCallback f()
  {
    return null;
  }
  
  void g()
  {
    i();
    if (q()) {
      VasWebviewUtil.a(this.Q.getCurrentUin(), "group_nickname", "uv", "", 1, 0, 0, "", "", "");
    }
    if (r())
    {
      this.B = ((SoftInputDetectView)e(2131435828));
      this.B.setOnImStateChangedListener(this.O);
      this.a.setEditableFactory(NickColorEmoticonBuilder.a);
      this.a.setOnClickListener(this);
      this.v = ((RelativeLayout)e(2131430959));
      this.x = ((RecyclerView)e(2131430944));
      this.y = new GridLayoutManager(this.R, 3);
      this.x.setLayoutManager(this.y);
      this.z = new ColorNickColorPanelAdapter(this.R, this.N);
      this.x.setAdapter(this.z);
      this.x.addOnScrollListener(this.ae);
      this.q = ((RelativeLayout)e(2131430941));
      this.q.setVisibility(0);
      this.u = ((ImageView)e(2131430942));
      this.u.setOnClickListener(this);
      this.t = ((ImageView)e(2131430945));
      this.t.setOnClickListener(this);
      this.w = ((RelativeLayout)e(2131430946));
      this.r = ((TextView)e(2131430958));
      this.s = ((TextView)e(2131430956));
      this.s.setOnClickListener(this);
      this.C = ((RelativeLayout)e(2131430951));
      this.F = ((ImageView)e(2131430949));
      this.F.setOnClickListener(this);
      this.D = ((ColorNickTextView)e(2131430952));
      this.E = ((TextView)e(2131430950));
      this.E.setOnClickListener(this);
      b(false);
      b(0);
      Object localObject = this.Q.getPreferences().getString("color_nick_last_edit", "");
      if (android.text.TextUtils.isEmpty((CharSequence)localObject))
      {
        this.C.setVisibility(8);
      }
      else
      {
        if (QLog.isColorLevel()) {
          QLog.d("ColorNick", 2, String.format("showing last nick and clear saved color nick.", new Object[0]));
        }
        this.C.setVisibility(0);
        localObject = new ColorNickText((CharSequence)localObject, 16).b();
        this.D.setText((CharSequence)localObject);
        ColorNickManager.a(this.Q, this.D, (Spannable)localObject, this.h, true);
        a(true);
      }
      localObject = this.a;
      if ((localObject instanceof ColorClearableEditText)) {
        ((ColorClearableEditText)localObject).setTextClearedListener(this.P);
      }
      this.a.setFilters(new InputFilter[] { new EditTroopMemberNickService.EmojiFilter() });
      if (QVipTroopNickProcessor.e().isEnable())
      {
        h();
        this.u.setVisibility(8);
      }
      else
      {
        this.u.setVisibility(0);
      }
    }
    else if (a(null))
    {
      this.a.setText("");
    }
    int i1 = this.a.getText().length();
    Selection.setSelection(this.a.getEditableText(), i1);
    m();
    ReportController.b(this.Q, "dc00899", "Grp_set", "", "nickname edit", "nickname edit_exp", 0, 0, String.valueOf(this.j), "", "", "");
  }
  
  public void h()
  {
    this.K = ((ShopLayout)e(2131448138));
    if (this.K != null)
    {
      if (android.text.TextUtils.isEmpty(this.j)) {
        return;
      }
      this.K.setHideInputmethod(new EditTroopMemberNickService.4(this));
      this.K.getAdapter().a(new EditTroopMemberNickService.5(this));
      this.K.setRequest(new TroopNickRequest(50, Long.parseLong(this.j), this.K.getAdapter()));
      ShopLayout localShopLayout = this.K;
      if (localShopLayout != null)
      {
        localShopLayout.setShopCallback(new EditTroopMemberNickService.6(this));
        this.K.setAppId(50);
      }
    }
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
      break;
    case 260: 
      ColorNickManager.a(this.Q).b.a(this.aa);
      paramMessage = this.A;
      if (paramMessage != null) {
        paramMessage.init(this.Q, 100001, this.R, v(), null, null, false, ColorNickManager.a(this.Q).b);
      }
      break;
    case 259: 
      if (QLog.isColorLevel()) {
        QLog.d("ColorNick", 2, String.format("MSG_TYPE_CLEAR_COLOR_NICK. saveColorNick", new Object[0]));
      }
      a(false);
      i();
      break;
    case 258: 
      p();
      break;
    case 257: 
      paramMessage = this.A;
      if (paramMessage != null)
      {
        paramMessage.setSecondTabInited(false);
        this.A.switchTabMode(0);
      }
      break;
    }
    return true;
  }
  
  protected void i()
  {
    Object localObject = this.g;
    if ((localObject != null) && (((String)localObject).length() > 0)) {
      if (r()) {
        this.a.setText(this.g);
      } else {
        this.a.setText(ColorNickManager.b(this.g));
      }
    }
    int i1 = this.h;
    if (i1 > 0)
    {
      localObject = this.a;
      if ((localObject instanceof ColorClearableEditText)) {
        ((ColorClearableEditText)localObject).setCustomCloth(i1, true);
      }
    }
    if (r()) {
      p();
    }
  }
  
  protected void j()
  {
    ShopLayout localShopLayout = this.K;
    if (localShopLayout != null) {
      localShopLayout.b();
    }
  }
  
  protected void k() {}
  
  protected void l()
  {
    this.Q.removeObserver(this.M);
    this.Q.removeObserver(this.ad);
    Object localObject = this.L;
    if (localObject != null) {
      ((Handler)localObject).removeCallbacksAndMessages(null);
    }
    localObject = this.A;
    if (localObject != null) {
      ((IEmoticonMainPanel)localObject).onDestory();
    }
    this.Q.removeObserver(this.ac);
    ColorNickManager.a(this.Q).c = null;
  }
  
  public void onClick(View paramView)
  {
    Object localObject;
    switch (paramView.getId())
    {
    default: 
      break;
    case 2131430956: 
      VasH5PayUtil.a(this.R, "mvip.g.a.qnc_kt", "CJCLUBT", -1, false, true);
      VasWebviewUtil.a(this.Q.getCurrentUin(), "group_nickname", "group_nickname_3", "", 1, 0, 0, "", "", "");
      break;
    case 2131430950: 
      localObject = new ColorNickText(this.D.getText().toString(), 32).b();
      this.a.setText((CharSequence)localObject);
      ColorNickManager.a(this.Q, this.a, (Spannable)localObject);
      this.C.setVisibility(8);
      break;
    case 2131430949: 
      this.C.setVisibility(8);
      break;
    case 2131430945: 
      if (this.ab == 1) {
        localObject = "2";
      } else {
        localObject = "1";
      }
      if (this.U)
      {
        this.V = 1;
        this.S.hideInputMethod();
      }
      else
      {
        c(1);
      }
      VasWebviewUtil.a(this.Q.getCurrentUin(), "group_nickname", "group_nickname_5", "", 1, 0, 0, "", (String)localObject, "");
      break;
    case 2131430942: 
      if (this.ab == 2) {
        localObject = "2";
      } else {
        localObject = "1";
      }
      if (this.U)
      {
        this.V = 2;
        this.S.hideInputMethod();
      }
      else
      {
        c(2);
      }
      VasWebviewUtil.a(this.Q.getCurrentUin(), "group_nickname", "group_nickname_6", "", 1, 0, 0, "", (String)localObject, "");
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
    EditText localEditText = this.a;
    if ((localEditText instanceof ColorClearableEditText))
    {
      this.X = true;
      if ((paramEmoticonInfo instanceof SystemAndEmojiEmoticonInfo))
      {
        paramEmoticonInfo = (SystemAndEmojiEmoticonInfo)paramEmoticonInfo;
        if (paramEmoticonInfo.code == -1) {
          return;
        }
        int i1 = this.a.getSelectionStart();
        int i2 = this.a.getSelectionEnd();
        this.a.getEditableText().replace(i1, i2, com.tencent.mobileqq.text.TextUtils.getColorNickSysEmoticonString(paramEmoticonInfo.code));
        this.a.requestFocus();
        return;
      }
      if ((paramEmoticonInfo instanceof ISmallEmoticonInfo)) {
        ColorNickManager.a((ISmallEmoticonInfo)paramEmoticonInfo, this.Q, localEditText);
      }
    }
  }
  
  public void setting() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.editservice.EditTroopMemberNickService
 * JD-Core Version:    0.7.0.1
 */