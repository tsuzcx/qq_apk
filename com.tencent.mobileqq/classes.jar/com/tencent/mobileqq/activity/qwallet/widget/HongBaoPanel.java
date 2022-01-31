package com.tencent.mobileqq.activity.qwallet.widget;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.os.Build.VERSION;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ItemAnimator;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.aio.CustomizeStrategyFactory;
import com.tencent.mobileqq.activity.aio.CustomizeStrategyFactory.OnCustomizeListener;
import com.tencent.mobileqq.activity.aio.CustomizeStrategyFactory.RedPacketInfo;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.qwallet.TroopUnAccalimedRedPacketList;
import com.tencent.mobileqq.activity.qwallet.config.QWalletConfigManager;
import com.tencent.mobileqq.activity.qwallet.red.QWalletRedManager;
import com.tencent.mobileqq.activity.qwallet.red.QWalletRedManager.ShowInfo;
import com.tencent.mobileqq.activity.qwallet.redpacket.PanelData;
import com.tencent.mobileqq.activity.qwallet.redpacket.PanelTabData;
import com.tencent.mobileqq.activity.qwallet.redpacket.RedPacketManager;
import com.tencent.mobileqq.activity.qwallet.utils.QWalletRedPkgUtils;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;

public class HongBaoPanel
  extends RelativeLayout
  implements View.OnClickListener
{
  private static final String TAG = "HongBaoPanel";
  private final int REQ_ID_ACTION_BACKGROUND = 101;
  private final int REQ_ID_ACTION_ICON = 102;
  private final int REQ_ID_PANNEL_BACKGROUND = 100;
  private String actionId;
  private View.OnClickListener bottomTabClickListener = new HongBaoPanel.2(this);
  private LinearLayout bottomTabLayout;
  private int failedImageReTryTimes;
  private List failedPositionList = new ArrayList();
  private String fontColorAct;
  private String fontColorIcon;
  private String fontColorTab;
  private boolean isNightMode;
  boolean isSoftKeyBoardHeight = false;
  int itemTopMargin = ImmersiveUtils.a(14.0F);
  private RelativeLayout layoutAction;
  private RelativeLayout layoutBottom;
  ViewGroup mAIORootView;
  CustomizeStrategyFactory.OnCustomizeListener mActionCustomListener = new HongBaoPanel.1(this);
  private ImageView mActionRedDot;
  private TextView mActionTxtView;
  protected BaseActivity mActivity;
  HongBaoPanel.HongBaoAdapter mAdapter;
  public QQAppInterface mApp;
  BaseChatPie mBaseChatPie;
  protected Context mContext;
  private RecyclerView mHbRecyclerView;
  HongBaoPanel.OnHolderItemClickListener mHolderItemClickListener = new HongBaoPanel.4(this);
  private ImageView mImgActionFire;
  private ImageView mImgPanelBackGround;
  GridLayoutManager mLayoutManager;
  SessionInfo mSessionInfo;
  private String panelBgColor;
  private String panelBgPic;
  QWalletRedManager redManager;
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
    return CustomizeStrategyFactory.a().a(this.mApp, localRedPacketInfo, new HongBaoPanel.3(this, paramString, paramImageView, paramInt));
  }
  
  private void gotoTroopNotReceive()
  {
    String str = this.mSessionInfo.jdField_a_of_type_JavaLangString;
    int i = this.mSessionInfo.jdField_a_of_type_Int;
    new TroopUnAccalimedRedPacketList(this.mApp, this.mBaseChatPie).a(str, i);
  }
  
  private void initBottomTabStatus()
  {
    List localList = ((RedPacketManager)RedPacketManager.getInstance()).getPanelTabList(this.mSessionInfo);
    if ((localList == null) || (localList.size() <= 0)) {
      this.layoutAction.setVisibility(8);
    }
    for (;;)
    {
      return;
      int i = 0;
      while (i < localList.size())
      {
        PanelTabData localPanelTabData = (PanelTabData)localList.get(i);
        if (i != 0)
        {
          localObject = new View(this.mContext);
          localLayoutParams = new LinearLayout.LayoutParams(ImmersiveUtils.a(0.5F), ImmersiveUtils.a(15.0F));
          localLayoutParams.leftMargin = ImmersiveUtils.a(9.0F);
          ((View)localObject).setLayoutParams(localLayoutParams);
          ((View)localObject).setBackgroundColor(Color.parseColor("#DEDEDE"));
          this.bottomTabLayout.addView((View)localObject);
        }
        Object localObject = new TextView(this.mContext);
        this.bottomTabLayout.addView((View)localObject);
        ((TextView)localObject).setTag(localPanelTabData);
        ((TextView)localObject).setOnClickListener(this.bottomTabClickListener);
        ((TextView)localObject).setTextSize(2, 12.0F);
        LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)((TextView)localObject).getLayoutParams();
        localLayoutParams.gravity = 16;
        ((TextView)localObject).setGravity(1);
        if (i != 0) {
          localLayoutParams.leftMargin = ImmersiveUtils.a(10.0F);
        }
        if (StringUtil.a(this.fontColorTab)) {
          this.fontColorTab = "#27BEF6";
        }
        setTextViewNameColor((TextView)localObject, localPanelTabData.b, this.fontColorTab);
        i += 1;
      }
    }
  }
  
  private void initPanelBgAndHongBaoAction()
  {
    Object localObject2 = (QWalletConfigManager)this.mApp.getManager(244);
    if (isInValidTime((QWalletConfigManager)localObject2, ((QWalletConfigManager)localObject2).a("redPackPanel", "", new String[] { "themeInfo", "begintime" }), ((QWalletConfigManager)localObject2).a("redPackPanel", "", new String[] { "themeInfo", "endtime" })))
    {
      this.fontColorIcon = ((QWalletConfigManager)localObject2).a("redPackPanel", "#000000", new String[] { "themeInfo", "fontColorIcon" });
      this.fontColorAct = ((QWalletConfigManager)localObject2).a("redPackPanel", "#000000", new String[] { "themeInfo", "fontColorAct" });
      this.fontColorTab = ((QWalletConfigManager)localObject2).a("redPackPanel", "#000000", new String[] { "themeInfo", "fontColorTab" });
      this.panelBgPic = ((QWalletConfigManager)localObject2).a("redPackPanel", "", new String[] { "themeInfo", "panelPic" });
      this.panelBgColor = ((QWalletConfigManager)localObject2).a("redPackPanel", "", new String[] { "themeInfo", "panelColor" });
    }
    Object localObject1;
    if (!StringUtil.a(this.panelBgPic))
    {
      localObject1 = new CustomizeStrategyFactory.RedPacketInfo();
      ((CustomizeStrategyFactory.RedPacketInfo)localObject1).skinType = 100;
      ((CustomizeStrategyFactory.RedPacketInfo)localObject1).templateId = this.panelBgPic;
      ((CustomizeStrategyFactory.RedPacketInfo)localObject1).type = 7;
      localObject1 = CustomizeStrategyFactory.a().a(this.mApp, (CustomizeStrategyFactory.RedPacketInfo)localObject1, this.mActionCustomListener);
      if (localObject1 != null) {
        updatePanelPictures((CustomizeStrategyFactory.RedPacketInfo)localObject1);
      }
    }
    for (;;)
    {
      localObject1 = ((QWalletConfigManager)localObject2).a("redPackPanel", new String[] { "panelAct" });
      if (localObject1 != null) {
        if (isInValidTime((QWalletConfigManager)localObject2, ((QWalletConfigManager)localObject2).a("redPackPanel", "", new String[] { "panelAct", "params", "begintime" }), ((QWalletConfigManager)localObject2).a("redPackPanel", "", new String[] { "panelAct", "params", "endtime" })))
        {
          localObject2 = ((JSONObject)localObject1).optJSONObject("params");
          if (localObject2 != null) {
            this.url_action = ((JSONObject)localObject2).optString("url");
          }
          if (!StringUtil.a(this.url_action))
          {
            this.layoutAction.setVisibility(0);
            setTextViewNameColor(this.mActionTxtView, ((JSONObject)localObject1).optString("name"), this.fontColorAct);
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
      if (!StringUtil.a(this.panelBgColor))
      {
        try
        {
          setBackgroundColor(Color.parseColor(this.panelBgColor));
        }
        catch (Throwable localThrowable)
        {
          localThrowable.printStackTrace();
        }
      }
      else if (this.isNightMode)
      {
        setBackgroundColor(Color.parseColor("#062C4F"));
        this.setNightColorSucc = true;
      }
    }
  }
  
  private boolean isInValidTime(QWalletConfigManager paramQWalletConfigManager, String paramString1, String paramString2)
  {
    if (paramQWalletConfigManager == null) {
      return false;
    }
    try
    {
      boolean bool = RedPacketManager.isValidDate(paramString1, paramString2);
      return bool;
    }
    catch (Throwable paramQWalletConfigManager)
    {
      paramQWalletConfigManager.printStackTrace();
    }
    return false;
  }
  
  private void setTextViewNameColor(TextView paramTextView, String paramString1, String paramString2)
  {
    String str;
    if (paramTextView != null) {
      str = paramString2;
    }
    try
    {
      paramTextView.setText(paramString1);
      paramString1 = paramString2;
      str = paramString2;
      if (this.isNightMode)
      {
        paramString1 = paramString2;
        str = paramString2;
        if (this.setNightColorSucc) {
          paramString1 = "#898B93";
        }
      }
      str = paramString1;
      if (!StringUtil.a(paramString1))
      {
        str = paramString1;
        paramTextView.setTextColor(Color.parseColor(paramString1));
      }
      return;
    }
    catch (Throwable paramTextView)
    {
      do
      {
        paramTextView.printStackTrace();
      } while (!QLog.isColorLevel());
      QLog.d("HongBaoPanel", 2, "maybe parseColor failed--------,color=" + str);
    }
  }
  
  private void updateActionRedDotById(String paramString)
  {
    ImageView localImageView;
    if ((!StringUtil.a(paramString)) && (this.redManager != null))
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
    try
    {
      switch (paramRedPacketInfo.skinType)
      {
      case 102: 
        if ((paramRedPacketInfo != null) && (paramRedPacketInfo.icon != null))
        {
          this.mImgActionFire.setImageBitmap(paramRedPacketInfo.icon);
          return;
        }
        break;
      }
    }
    catch (Throwable paramRedPacketInfo)
    {
      if (QLog.isColorLevel())
      {
        QLog.i("HongBaoPanel", 2, "updatePanelPictures exception =" + paramRedPacketInfo.toString());
        return;
        if ((paramRedPacketInfo != null) && (paramRedPacketInfo.icon != null))
        {
          if (Build.VERSION.SDK_INT < 16)
          {
            this.layoutAction.setBackgroundDrawable(new BitmapDrawable(this.mContext.getResources(), paramRedPacketInfo.icon));
            return;
          }
          this.layoutAction.setBackground(new BitmapDrawable(this.mContext.getResources(), paramRedPacketInfo.icon));
          return;
          if ((paramRedPacketInfo != null) && (paramRedPacketInfo.icon != null))
          {
            this.mImgPanelBackGround.setVisibility(0);
            this.mImgPanelBackGround.setImageBitmap(paramRedPacketInfo.icon);
            return;
          }
          if (this.isNightMode)
          {
            setBackgroundColor(Color.parseColor("#062C4F"));
            this.setNightColorSucc = true;
            return;
          }
        }
      }
    }
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
      localArrayList.add(((PanelData)((List)localObject).get(i)).jdField_a_of_type_JavaLangString);
      i += 1;
    }
    localObject = ((QWalletConfigManager)this.mApp.getManager(244)).a("redPackPanel", new String[] { "panelAct" });
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
    this.redManager = ((QWalletRedManager)this.mApp.getManager(272));
    this.mAIORootView = paramBaseChatPie.c;
    this.mSessionInfo = paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo;
    this.mImgPanelBackGround = ((ImageView)findViewById(2131367923));
    this.mHbRecyclerView = ((RecyclerView)findViewById(2131367929));
    this.mHbRecyclerView.setHasFixedSize(true);
    this.layoutBottom = ((RelativeLayout)findViewById(2131364920));
    this.bottomTabLayout = ((LinearLayout)findViewById(2131367924));
    this.mImgActionFire = ((ImageView)findViewById(2131367926));
    this.layoutAction = ((RelativeLayout)findViewById(2131367925));
    this.layoutAction.setVisibility(8);
    this.mActionRedDot = ((ImageView)findViewById(2131367928));
    this.mActionRedDot.setVisibility(8);
    this.layoutAction.setOnClickListener(this);
    this.mActionTxtView = ((TextView)findViewById(2131367927));
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
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      return;
    }
    if ((this.mContext != null) && (!StringUtil.a(this.url_action))) {
      QWalletRedPkgUtils.b(this.mContext, this.url_action);
    }
    if (this.redManager != null) {
      this.redManager.a(this.actionId);
    }
    updateActionRedDotById(this.actionId);
  }
  
  public void onDestory()
  {
    this.failedImageReTryTimes = 0;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.qwallet.widget.HongBaoPanel
 * JD-Core Version:    0.7.0.1
 */