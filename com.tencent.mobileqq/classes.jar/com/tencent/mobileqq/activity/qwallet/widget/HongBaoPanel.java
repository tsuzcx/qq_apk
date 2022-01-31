package com.tencent.mobileqq.activity.qwallet.widget;

import aere;
import aetu;
import aixs;
import ajan;
import ajbp;
import ajbr;
import ajbs;
import ajbt;
import ajet;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ItemAnimator;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.TextView;
import azqs;
import bayu;
import bdnn;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.aio.CustomizeStrategyFactory;
import com.tencent.mobileqq.activity.aio.CustomizeStrategyFactory.RedPacketInfo;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.qwallet.TroopUnAccalimedRedPacketList;
import com.tencent.mobileqq.activity.qwallet.emoj.EmojiRedpacketUserGuideDialog;
import com.tencent.mobileqq.activity.qwallet.preload.PreloadManager;
import com.tencent.mobileqq.activity.qwallet.redpacket.RedPacketManager;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.immersive.ImmersiveUtils;
import cooperation.qwallet.plugin.QWalletPicHelper;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

public class HongBaoPanel
  extends RelativeLayout
  implements View.OnClickListener
{
  public static final String CLR_DEF_ACT_TXT = "#000000";
  private static final String CLR_DEF_ACT_TXT_NIGHT = "#737373";
  public static final String CLR_DEF_BOTTOM_TAB_TXT = "#27BEF6";
  private static final String CLR_DEF_BOTTOM_TAB_TXT_NIGHT = "#004080";
  public static final String CLR_DEF_RED_BG = "#FFFFFF";
  private static final String CLR_DEF_RED_BG_NIGHT = "#000000";
  public static final String CLR_DEF_RED_ICON_TXT = "#5B6175";
  public static final int REQ_ID_ACTION_BACKGROUND = 101;
  public static final int REQ_ID_ACTION_ICON = 102;
  public static final int REQ_ID_PANNEL_BACKGROUND = 100;
  private static final String TAG = "HongBaoPanel";
  private static final int TXT_TYPE_ACT = 2;
  private static final int TXT_TYPE_BOTTOM_TAB = 1;
  private static final int TXT_TYPE_RED_ICON = 0;
  private String actionId;
  private View.OnClickListener bottomTabClickListener = new HongBaoPanel.3(this);
  private LinearLayout bottomTabLayout;
  private int failedImageReTryTimes;
  private List<Integer> failedPositionList = new ArrayList();
  private String fontColorAct = "#000000";
  private String fontColorIcon = "#5B6175";
  private String fontColorTab = "#27BEF6";
  private boolean isNightMode;
  boolean isSoftKeyBoardHeight = false;
  int itemTopMargin = ImmersiveUtils.a(14.0F);
  private RelativeLayout layoutAction;
  private RelativeLayout layoutBottom;
  ViewGroup mAIORootView;
  aere mActionCustomListener = new HongBaoPanel.1(this);
  private ImageView mActionRedDot;
  private TextView mActionTxtView;
  protected BaseActivity mActivity;
  HongBaoPanel.HongBaoAdapter mAdapter;
  public QQAppInterface mApp;
  BaseChatPie mBaseChatPie;
  protected Context mContext;
  private RecyclerView mHbRecyclerView;
  HongBaoPanel.OnHolderItemClickListener mHolderItemClickListener = new HongBaoPanel.5(this);
  private ImageView mImgActionFire;
  private ImageView mImgPanelBackGround;
  GridLayoutManager mLayoutManager;
  private Integer mNightModeIconTxtColor;
  SessionInfo mSessionInfo;
  private TroopUnAccalimedRedPacketList mTroopUnAccalimedRedPacketList;
  private String panelBgColor;
  private String panelBgPic;
  ajbp redManager;
  private boolean setNightColorSucc;
  int spanCount = 4;
  private String url_action;
  
  public HongBaoPanel(Context paramContext)
  {
    super(paramContext);
  }
  
  public HongBaoPanel(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  private CustomizeStrategyFactory.RedPacketInfo getItemDataAndBitmap(int paramInt, String paramString, ImageView paramImageView)
  {
    CustomizeStrategyFactory.RedPacketInfo localRedPacketInfo = new CustomizeStrategyFactory.RedPacketInfo();
    localRedPacketInfo.type = 7;
    localRedPacketInfo.templateId = paramString;
    return CustomizeStrategyFactory.a().a(this.mApp, localRedPacketInfo, new HongBaoPanel.4(this, paramString, paramImageView, paramInt));
  }
  
  private int getNightModeIconTxtColor()
  {
    if (this.mNightModeIconTxtColor == null) {
      this.mNightModeIconTxtColor = Integer.valueOf(getResources().getColor(2131166903));
    }
    return this.mNightModeIconTxtColor.intValue();
  }
  
  private void gotoTroopNotReceive()
  {
    if ((this.mBaseChatPie == null) || (this.mBaseChatPie.a() == null) || (this.mSessionInfo == null))
    {
      if (QLog.isColorLevel()) {
        QLog.e("HongBaoPanel", 2, "open troop red package fail!!!");
      }
      return;
    }
    try
    {
      String str = this.mSessionInfo.jdField_a_of_type_JavaLangString;
      int i = this.mSessionInfo.jdField_a_of_type_Int;
      if (this.mTroopUnAccalimedRedPacketList == null) {
        this.mTroopUnAccalimedRedPacketList = new TroopUnAccalimedRedPacketList(this.mApp, this.mBaseChatPie);
      }
      this.mTroopUnAccalimedRedPacketList.a(str, i);
      return;
    }
    catch (Throwable localThrowable)
    {
      QLog.e("HongBaoPanel", 2, "open troop red package fail: " + localThrowable);
    }
  }
  
  private void initBottomTabStatus()
  {
    List localList = ((RedPacketManager)RedPacketManager.getInstance()).getPanelTabList(this.mSessionInfo);
    if ((localList == null) || (localList.size() <= 0))
    {
      this.bottomTabLayout.setVisibility(8);
      return;
    }
    int i = 0;
    label42:
    Object localObject2;
    Object localObject1;
    if (i < localList.size())
    {
      localObject2 = (ajbt)localList.get(i);
      if (i != 0)
      {
        localObject3 = new View(this.mContext);
        localObject1 = new LinearLayout.LayoutParams(ImmersiveUtils.a(0.5F), ImmersiveUtils.a(15.0F));
        ((LinearLayout.LayoutParams)localObject1).leftMargin = ImmersiveUtils.a(9.0F);
        ((View)localObject3).setLayoutParams((ViewGroup.LayoutParams)localObject1);
        if (!isNightModeTxtEnable()) {
          break label290;
        }
        localObject1 = "#737373";
        label129:
        ((View)localObject3).setBackgroundColor(Color.parseColor((String)localObject1));
        this.bottomTabLayout.addView((View)localObject3);
      }
      localObject1 = new TextView(this.mContext);
      this.bottomTabLayout.addView((View)localObject1);
      ((TextView)localObject1).setTag(localObject2);
      ((TextView)localObject1).setOnClickListener(this.bottomTabClickListener);
      ((TextView)localObject1).setTextSize(2, 12.0F);
      Object localObject3 = (LinearLayout.LayoutParams)((TextView)localObject1).getLayoutParams();
      ((LinearLayout.LayoutParams)localObject3).gravity = 16;
      ((TextView)localObject1).setGravity(1);
      if (i != 0) {
        ((LinearLayout.LayoutParams)localObject3).leftMargin = ImmersiveUtils.a(10.0F);
      }
      if (bdnn.a(this.fontColorTab)) {
        this.fontColorTab = "#27BEF6";
      }
      localObject2 = ((ajbt)localObject2).b;
      if (!"#27BEF6".equals(this.fontColorTab)) {
        break label297;
      }
    }
    label290:
    label297:
    for (int j = this.mContext.getResources().getColor(2131166914);; j = Color.parseColor(this.fontColorTab))
    {
      setTextViewNameColor((TextView)localObject1, (String)localObject2, j, 1);
      i += 1;
      break label42;
      break;
      localObject1 = "#DEDEDE";
      break label129;
    }
  }
  
  private void initPanelBgAndHongBaoAction()
  {
    Object localObject2 = (aixs)this.mApp.getManager(245);
    if (isInValidTime((aixs)localObject2, ((aixs)localObject2).a("redPackPanel", "", new String[] { "themeInfo", "begintime" }), ((aixs)localObject2).a("redPackPanel", "", new String[] { "themeInfo", "endtime" })))
    {
      this.fontColorIcon = ((aixs)localObject2).a("redPackPanel", "#5B6175", new String[] { "themeInfo", "fontColorIcon" });
      this.fontColorAct = ((aixs)localObject2).a("redPackPanel", "#000000", new String[] { "themeInfo", "fontColorAct" });
      this.fontColorTab = ((aixs)localObject2).a("redPackPanel", "#27BEF6", new String[] { "themeInfo", "fontColorTab" });
      this.panelBgPic = ((aixs)localObject2).a("redPackPanel", "", new String[] { "themeInfo", "panelPic" });
      this.panelBgColor = ((aixs)localObject2).a("redPackPanel", "#FFFFFF", new String[] { "themeInfo", "panelColor" });
    }
    if (ThemeUtil.isCustomTheme(false))
    {
      this.fontColorTab = "#27BEF6";
      this.fontColorIcon = "#5B6175";
      this.panelBgColor = "";
    }
    if (!bdnn.a(this.panelBgColor)) {}
    try
    {
      setBackgroundColor(Color.parseColor(this.panelBgColor));
      if (!bdnn.a(this.panelBgPic))
      {
        Object localObject1 = new CustomizeStrategyFactory.RedPacketInfo();
        ((CustomizeStrategyFactory.RedPacketInfo)localObject1).skinType = 100;
        ((CustomizeStrategyFactory.RedPacketInfo)localObject1).templateId = this.panelBgPic;
        ((CustomizeStrategyFactory.RedPacketInfo)localObject1).type = 7;
        localObject1 = CustomizeStrategyFactory.a().a(this.mApp, (CustomizeStrategyFactory.RedPacketInfo)localObject1, this.mActionCustomListener);
        if (localObject1 != null) {
          updatePanelPictures((CustomizeStrategyFactory.RedPacketInfo)localObject1);
        }
        localObject1 = ((aixs)localObject2).a("redPackPanel", new String[] { "panelAct" });
        if (localObject1 != null) {
          if (isInValidTime((aixs)localObject2, ((aixs)localObject2).a("redPackPanel", "", new String[] { "panelAct", "params", "begintime" }), ((aixs)localObject2).a("redPackPanel", "", new String[] { "panelAct", "params", "endtime" })))
          {
            localObject2 = ((JSONObject)localObject1).optJSONObject("params");
            if (localObject2 != null) {
              this.url_action = ((JSONObject)localObject2).optString("url");
            }
            if (!bdnn.a(this.url_action))
            {
              this.layoutAction.setVisibility(0);
              setTextViewNameColor(this.mActionTxtView, ((JSONObject)localObject1).optString("name"), Color.parseColor(this.fontColorAct), 2);
              localObject2 = ((JSONObject)localObject1).optString("bubble_pic");
              CustomizeStrategyFactory.RedPacketInfo localRedPacketInfo = new CustomizeStrategyFactory.RedPacketInfo();
              localRedPacketInfo.skinType = 101;
              localRedPacketInfo.templateId = ((String)localObject2);
              localRedPacketInfo.type = 7;
              localObject2 = CustomizeStrategyFactory.a().a(this.mApp, localRedPacketInfo, this.mActionCustomListener);
              if (localObject2 != null) {
                updatePanelPictures((CustomizeStrategyFactory.RedPacketInfo)localObject2);
              }
              localObject2 = ((JSONObject)localObject1).optString("icon_pic");
              localRedPacketInfo = new CustomizeStrategyFactory.RedPacketInfo();
              localRedPacketInfo.skinType = 102;
              localRedPacketInfo.templateId = ((String)localObject2);
              localRedPacketInfo.type = 7;
              localObject2 = CustomizeStrategyFactory.a().a(this.mApp, localRedPacketInfo, this.mActionCustomListener);
              if (localObject2 != null) {
                updatePanelPictures((CustomizeStrategyFactory.RedPacketInfo)localObject2);
              }
              this.actionId = ((JSONObject)localObject1).optString("id");
              updateActionRedDotById(this.actionId);
            }
          }
        }
        return;
      }
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        localThrowable.printStackTrace();
        continue;
        if (this.isNightMode)
        {
          setBackgroundColor(Color.parseColor("#000000"));
          this.setNightColorSucc = true;
        }
        else
        {
          setBackgroundResource(2130849680);
        }
      }
    }
  }
  
  private boolean isInValidTime(aixs paramaixs, String paramString1, String paramString2)
  {
    if (paramaixs == null) {
      return false;
    }
    try
    {
      boolean bool = RedPacketManager.isValidDate(paramString1, paramString2);
      return bool;
    }
    catch (Throwable paramaixs)
    {
      paramaixs.printStackTrace();
    }
    return false;
  }
  
  private boolean isNightModeTxtEnable()
  {
    return (this.isNightMode) && (this.setNightColorSucc);
  }
  
  private void setTextViewNameColor(TextView paramTextView, String paramString, int paramInt1, int paramInt2)
  {
    int j;
    if (paramTextView != null)
    {
      j = paramInt1;
      for (;;)
      {
        try
        {
          paramTextView.setText(paramString);
          i = paramInt1;
          j = paramInt1;
          if (isNightModeTxtEnable()) {
            switch (paramInt2)
            {
            }
          }
        }
        catch (Throwable paramTextView)
        {
          paramTextView.printStackTrace();
          if (!QLog.isColorLevel()) {
            return;
          }
          QLog.d("HongBaoPanel", 2, "maybe parseColor failed--------,color=" + j);
          return;
          int i = paramInt1;
          continue;
        }
        j = i;
        paramTextView.setTextColor(i);
        return;
        j = paramInt1;
        i = getNightModeIconTxtColor();
        continue;
        j = paramInt1;
        i = Color.parseColor("#004080");
        continue;
        j = paramInt1;
        i = Color.parseColor("#737373");
      }
    }
  }
  
  private void updateActionRedDotById(String paramString)
  {
    ImageView localImageView;
    if ((!bdnn.a(paramString)) && (this.redManager != null))
    {
      paramString = this.redManager.a(paramString);
      if (paramString != null)
      {
        localImageView = this.mActionRedDot;
        if (!paramString.a) {
          break label47;
        }
      }
    }
    label47:
    for (int i = 0;; i = 8)
    {
      localImageView.setVisibility(i);
      return;
    }
  }
  
  private void updatePanelPictures(CustomizeStrategyFactory.RedPacketInfo paramRedPacketInfo)
  {
    if (paramRedPacketInfo == null) {}
    label244:
    do
    {
      do
      {
        do
        {
          do
          {
            return;
            try
            {
              switch (paramRedPacketInfo.skinType)
              {
              case 100: 
                if ((paramRedPacketInfo == null) || (TextUtils.isEmpty(paramRedPacketInfo.resPath))) {
                  break label244;
                }
                this.mImgPanelBackGround.setVisibility(0);
                Drawable localDrawable = QWalletPicHelper.getDrawableForAIO(paramRedPacketInfo.resPath, bayu.a);
                ((URLDrawable)localDrawable).setURLDrawableListener(new HongBaoPanel.2(this, paramRedPacketInfo, localDrawable));
                this.mImgPanelBackGround.setImageDrawable(localDrawable);
                return;
              }
            }
            catch (Throwable paramRedPacketInfo) {}
          } while (!QLog.isColorLevel());
          QLog.i("HongBaoPanel", 2, "updatePanelPictures exception =" + paramRedPacketInfo.toString());
          return;
        } while ((paramRedPacketInfo == null) || (paramRedPacketInfo.icon == null));
        this.mImgActionFire.setImageBitmap(paramRedPacketInfo.icon);
        return;
        if (isNightModeTxtEnable())
        {
          this.layoutAction.setBackgroundResource(2130846891);
          return;
        }
      } while ((paramRedPacketInfo == null) || (paramRedPacketInfo.icon == null));
      if (Build.VERSION.SDK_INT < 16)
      {
        this.layoutAction.setBackgroundDrawable(new BitmapDrawable(this.mContext.getResources(), paramRedPacketInfo.icon));
        return;
      }
      this.layoutAction.setBackground(new BitmapDrawable(this.mContext.getResources(), paramRedPacketInfo.icon));
      return;
    } while (!this.isNightMode);
    setBackgroundColor(Color.parseColor("#000000"));
    this.setNightColorSucc = true;
    return;
  }
  
  public void doRedManagerShowReport()
  {
    Object localObject = this.mAdapter.getDatas();
    if ((localObject == null) || (((List)localObject).size() <= 0)) {
      return;
    }
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    while (i < ((List)localObject).size())
    {
      localArrayList.add(((ajbs)((List)localObject).get(i)).jdField_a_of_type_JavaLangString);
      i += 1;
    }
    localObject = ((aixs)this.mApp.getManager(245)).a("redPackPanel", new String[] { "panelAct" });
    if (localObject != null) {
      localArrayList.add(((JSONObject)localObject).optString("id"));
    }
    this.redManager.a(localArrayList);
  }
  
  public void init(QQAppInterface paramQQAppInterface, Context paramContext, BaseChatPie paramBaseChatPie)
  {
    this.mApp = paramQQAppInterface;
    this.mContext = paramContext;
    this.isNightMode = ThemeUtil.isNowThemeIsNight(this.mApp, false, null);
    this.mBaseChatPie = paramBaseChatPie;
    this.mActivity = paramBaseChatPie.jdField_a_of_type_AndroidSupportV4AppFragmentActivity;
    this.redManager = ((ajbp)this.mApp.getManager(273));
    this.mAIORootView = paramBaseChatPie.c;
    this.mSessionInfo = paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo;
    this.mImgPanelBackGround = ((ImageView)findViewById(2131368079));
    this.mHbRecyclerView = ((RecyclerView)findViewById(2131367731));
    this.mHbRecyclerView.setHasFixedSize(true);
    this.layoutBottom = ((RelativeLayout)findViewById(2131369168));
    this.bottomTabLayout = ((LinearLayout)findViewById(2131369170));
    this.mImgActionFire = ((ImageView)findViewById(2131368120));
    this.layoutAction = ((RelativeLayout)findViewById(2131367716));
    this.layoutAction.setVisibility(8);
    this.mActionRedDot = ((ImageView)findViewById(2131361908));
    this.mActionRedDot.setVisibility(8);
    this.layoutAction.setOnClickListener(this);
    this.mActionTxtView = ((TextView)findViewById(2131377632));
    this.mLayoutManager = new GridLayoutManager(this.mContext, this.spanCount);
    this.mLayoutManager.setOrientation(1);
    this.mHbRecyclerView.setLayoutManager(this.mLayoutManager);
    this.mHbRecyclerView.getItemAnimator().setChangeDuration(0L);
    this.mHbRecyclerView.addItemDecoration(new HongBaoPanel.SpaceItemDecoration(this));
    this.mAdapter = new HongBaoPanel.HongBaoAdapter(this);
    this.mHbRecyclerView.setAdapter(this.mAdapter);
    this.mAdapter.setOnItemClickListener(this.mHolderItemClickListener);
    initPanelBgAndHongBaoAction();
    initBottomTabStatus();
    paramQQAppInterface = ((RedPacketManager)RedPacketManager.getInstance()).getPanelList(this.mSessionInfo);
    this.mAdapter.setDatas(paramQQAppInterface);
    doRedManagerShowReport();
    preloadResource();
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      return;
    }
    if ((this.mContext != null) && (!bdnn.a(this.url_action))) {
      ajet.b(this.mContext, this.url_action);
    }
    if (this.redManager != null) {
      this.redManager.a(this.actionId);
    }
    updateActionRedDotById(this.actionId);
    paramView = "";
    int i;
    if ((this.mSessionInfo.jdField_a_of_type_Int == 0) || (this.mSessionInfo.jdField_a_of_type_Int == 1000) || (this.mSessionInfo.jdField_a_of_type_Int == 1004) || (this.mSessionInfo.jdField_a_of_type_Int == 1001) || (this.mSessionInfo.jdField_a_of_type_Int == 10002) || (this.mSessionInfo.jdField_a_of_type_Int == 10004) || (this.mSessionInfo.jdField_a_of_type_Int == 10008))
    {
      paramView = "entrance.click.c2c";
      i = aetu.a();
      if (i != 0) {
        break label278;
      }
      paramView = paramView + ".plus";
    }
    for (;;)
    {
      azqs.b(this.mApp, "P_CliOper", "Vip_pay_mywallet", "", "wallet", paramView, 0, 0, "10000", "", "", "");
      return;
      if (this.mSessionInfo.jdField_a_of_type_Int == 3000)
      {
        paramView = "entrance.click.group";
        break;
      }
      if (this.mSessionInfo.jdField_a_of_type_Int != 1) {
        break;
      }
      paramView = "entrance.click.chatgroup";
      break;
      label278:
      if (i == 1) {
        paramView = paramView + ".quick";
      }
    }
  }
  
  public void onDestory()
  {
    this.failedImageReTryTimes = 0;
    if ((this.mTroopUnAccalimedRedPacketList != null) && (this.mTroopUnAccalimedRedPacketList.a != null)) {
      this.mTroopUnAccalimedRedPacketList.a = null;
    }
  }
  
  public void preloadResource()
  {
    Object localObject = this.mAdapter.getDatas();
    if ((localObject == null) || (((List)localObject).size() <= 0)) {}
    ajbs localajbs;
    do
    {
      return;
      while (!((Iterator)localObject).hasNext()) {
        localObject = ((List)localObject).iterator();
      }
      localajbs = (ajbs)((Iterator)localObject).next();
    } while ((localajbs == null) || (localajbs.jdField_a_of_type_Int != 8));
    PreloadManager.a().c(EmojiRedpacketUserGuideDialog.URL_DEFAULT, null);
  }
  
  public void tryGetFailedImage()
  {
    if (QLog.isColorLevel()) {
      QLog.d("HongBaoPanel", 2, "failedImageReTryTimes=" + this.failedImageReTryTimes + ",failedPositionList=" + this.failedPositionList.toString());
    }
    int i = this.failedImageReTryTimes + 1;
    this.failedImageReTryTimes = i;
    if (i > 3) {}
    while ((this.failedPositionList == null) || (this.failedPositionList.size() <= 0)) {
      return;
    }
    i = 0;
    while (i < this.failedPositionList.size())
    {
      if (this.mAdapter != null) {
        this.mAdapter.notifyItemChanged(i);
      }
      i += 1;
    }
    this.failedPositionList.clear();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.qwallet.widget.HongBaoPanel
 * JD-Core Version:    0.7.0.1
 */