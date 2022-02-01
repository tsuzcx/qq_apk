package com.tencent.mobileqq.apollo.process.ui.framework;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.SparseIntArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.apollo.api.model.ApolloGameData;
import com.tencent.mobileqq.apollo.api.model.CmGamePushItem;
import com.tencent.mobileqq.apollo.cmgame.CmGameStartChecker.StartCheckParam;
import com.tencent.mobileqq.apollo.game.OnGameMenuListener;
import com.tencent.mobileqq.apollo.process.CmGameUtil;
import com.tencent.mobileqq.apollo.process.data.CmGameLauncher;
import com.tencent.mobileqq.apollo.store.ApolloGameActivity;
import com.tencent.mobileqq.apollo.view.FrameGifView;
import com.tencent.mobileqq.apollo.view.QQFrameZipDecoder;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.util.WeakReferenceHandler;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;
import com.tencent.widget.ActionSheetHelper;
import mqq.os.MqqHandler;
import mqq.util.WeakReference;

public class CmGameFloatView
  extends FrameworkView
  implements View.OnClickListener
{
  private int jdField_a_of_type_Int = 0;
  private SparseIntArray jdField_a_of_type_AndroidUtilSparseIntArray = new SparseIntArray();
  private View jdField_a_of_type_AndroidViewView;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private FrameGifView jdField_a_of_type_ComTencentMobileqqApolloViewFrameGifView;
  private ActionSheet.OnButtonClickListener jdField_a_of_type_ComTencentWidgetActionSheet$OnButtonClickListener = new CmGameFloatView.1(this);
  private ActionSheet jdField_a_of_type_ComTencentWidgetActionSheet;
  private boolean jdField_a_of_type_Boolean = false;
  private int jdField_b_of_type_Int = -1;
  private ImageView jdField_b_of_type_AndroidWidgetImageView;
  private boolean jdField_b_of_type_Boolean = false;
  private int jdField_c_of_type_Int = -1;
  private ImageView jdField_c_of_type_AndroidWidgetImageView;
  private boolean jdField_c_of_type_Boolean = false;
  private int jdField_d_of_type_Int = -1;
  private boolean jdField_d_of_type_Boolean = false;
  private int e = -1;
  private int f = -1;
  
  public CmGameFloatView(Context paramContext)
  {
    super(paramContext);
    a(paramContext);
  }
  
  public CmGameFloatView(Context paramContext, CmGameStartChecker.StartCheckParam paramStartCheckParam)
  {
    super(paramContext, paramStartCheckParam);
    a(paramContext);
    a(paramStartCheckParam);
    if ((paramStartCheckParam != null) && ((paramStartCheckParam.src == 319) || (paramStartCheckParam.src == 318))) {
      this.jdField_b_of_type_Boolean = true;
    }
  }
  
  private void a(Context paramContext)
  {
    RelativeLayout localRelativeLayout = (RelativeLayout)LayoutInflater.from(paramContext).inflate(2131558980, null);
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)localRelativeLayout.findViewById(2131364051));
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)localRelativeLayout.findViewById(2131363963));
    this.jdField_a_of_type_ComTencentMobileqqApolloViewFrameGifView = ((FrameGifView)localRelativeLayout.findViewById(2131364106));
    this.jdField_a_of_type_ComTencentMobileqqApolloViewFrameGifView.setPlayLoop(true);
    this.jdField_a_of_type_AndroidViewView = localRelativeLayout.findViewById(2131370406);
    this.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)localRelativeLayout.findViewById(2131371876));
    this.jdField_a_of_type_ComTencentMobileqqApolloViewFrameGifView.setVisibility(8);
    this.jdField_a_of_type_AndroidViewView.setVisibility(8);
    this.jdField_a_of_type_AndroidWidgetImageView.setBackgroundResource(2130838640);
    if (c()) {
      this.jdField_c_of_type_AndroidWidgetImageView.setVisibility(0);
    }
    this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this);
    this.jdField_b_of_type_AndroidWidgetImageView.setOnClickListener(this);
    this.jdField_a_of_type_ComTencentMobileqqApolloViewFrameGifView.setOnClickListener(this);
    addView(localRelativeLayout);
    localRelativeLayout = (RelativeLayout)((Activity)this.jdField_a_of_type_MqqUtilWeakReference.get()).findViewById(2131377365);
    int i = (int)paramContext.getResources().getDimension(2131296518);
    int j = (int)paramContext.getResources().getDimension(2131296517);
    paramContext = new RelativeLayout.LayoutParams(-2, -2);
    paramContext.addRule(11);
    paramContext.addRule(10);
    paramContext.rightMargin = j;
    paramContext.topMargin = i;
    localRelativeLayout.addView(this, paramContext);
  }
  
  private boolean c()
  {
    boolean bool = true;
    if ((this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam == null) || (this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.pushItem == null)) {
      bool = false;
    }
    while (this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.pushItem.is_show_red == 1) {
      return bool;
    }
    return false;
  }
  
  public void a()
  {
    this.jdField_a_of_type_AndroidWidgetImageView.setEnabled(false);
    this.jdField_b_of_type_AndroidWidgetImageView.setEnabled(false);
  }
  
  public void a(CmGameStartChecker.StartCheckParam paramStartCheckParam)
  {
    if ((paramStartCheckParam != null) && ((paramStartCheckParam.src == 319) || (paramStartCheckParam.src == 318)))
    {
      Bundle localBundle = new Bundle();
      localBundle.putString("key_game_friUin", paramStartCheckParam.mTempAIOUin);
      localBundle.putBoolean("key_open_voice", false);
      QIPCClientHelper.getInstance().callServer("cm_game_module", "action_aduio_enter_room", localBundle, null);
    }
  }
  
  public void a(boolean paramBoolean, String paramString)
  {
    if ((!TextUtils.isEmpty(paramString)) && (paramString.equals(this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.mTempAIOUin)))
    {
      this.jdField_c_of_type_Boolean = paramBoolean;
      ThreadManager.getUIHandler().post(new CmGameFloatView.2(this, paramBoolean));
    }
  }
  
  public void a(boolean paramBoolean, String paramString1, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("cmframe_CmGameFloatView", 2, new Object[] { "[updateRedPacketButton] isVisible=", Boolean.valueOf(paramBoolean), ", url=", paramString1, ", iconUrl=", paramString2 });
    }
    if ((paramBoolean) && (!TextUtils.isEmpty(paramString1)))
    {
      this.jdField_a_of_type_ComTencentMobileqqApolloViewFrameGifView.setVisibility(0);
      this.jdField_a_of_type_AndroidViewView.setVisibility(0);
      this.jdField_a_of_type_ComTencentMobileqqApolloViewFrameGifView.setTag(paramString1);
      this.jdField_a_of_type_AndroidWidgetImageView.setBackgroundResource(2130838639);
      if (!TextUtils.isEmpty(paramString2))
      {
        this.jdField_a_of_type_ComTencentMobileqqApolloViewFrameGifView.setGifData(100, null, paramString2, QQFrameZipDecoder.a(paramString2), true);
        if (this.jdField_a_of_type_ComTencentMobileqqApolloViewFrameGifView.b() == 3)
        {
          this.jdField_a_of_type_ComTencentMobileqqApolloViewFrameGifView.b();
          if (this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam == null) {
            break label350;
          }
        }
      }
    }
    label322:
    label350:
    for (paramString1 = String.valueOf(this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.gameId);; paramString1 = "")
    {
      VipUtils.a(null, "cmshow", "Apollo", "packetshow", 0, 0, new String[] { paramString1 });
      do
      {
        return;
        this.jdField_a_of_type_ComTencentMobileqqApolloViewFrameGifView.setImageResource(2130838641);
        break;
        this.jdField_a_of_type_ComTencentMobileqqApolloViewFrameGifView.setImageResource(2130838641);
        break;
        if (!this.jdField_b_of_type_Boolean) {
          break label322;
        }
        this.jdField_a_of_type_ComTencentMobileqqApolloViewFrameGifView.setGifData(100, null, "https://cmshow.gtimg.cn/client/img/apollo_game_audio_micBig.zip", QQFrameZipDecoder.a("https://cmshow.gtimg.cn/client/img/apollo_game_audio_micBig.zip"), false);
      } while (!this.jdField_d_of_type_Boolean);
      this.jdField_a_of_type_ComTencentMobileqqApolloViewFrameGifView.setVisibility(0);
      this.jdField_a_of_type_AndroidViewView.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetImageView.setBackgroundResource(2130838639);
      if (this.jdField_c_of_type_Boolean) {
        if (this.jdField_a_of_type_ComTencentMobileqqApolloViewFrameGifView.b() == 3) {
          this.jdField_a_of_type_ComTencentMobileqqApolloViewFrameGifView.b();
        }
      }
      for (;;)
      {
        this.jdField_a_of_type_Boolean = true;
        return;
        this.jdField_a_of_type_ComTencentMobileqqApolloViewFrameGifView.setImageResource(2130839345);
        continue;
        this.jdField_a_of_type_ComTencentMobileqqApolloViewFrameGifView.setImageResource(2130839343);
      }
      this.jdField_a_of_type_ComTencentMobileqqApolloViewFrameGifView.setVisibility(8);
      this.jdField_a_of_type_AndroidViewView.setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetImageView.setBackgroundResource(2130838640);
      return;
    }
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("cmframe_CmGameFloatView", 2, "[onQueryVoiceStatus] get voice status.");
    }
    this.jdField_d_of_type_Boolean = paramBoolean1;
    this.jdField_c_of_type_Boolean = paramBoolean2;
  }
  
  public boolean a()
  {
    return (this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam != null) && (this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.mGameType == 3);
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqApolloProcessDataCmGameLauncher != null)
    {
      String str = this.jdField_a_of_type_ComTencentMobileqqApolloProcessDataCmGameLauncher.a().mTempAIOUin;
      Bundle localBundle = new Bundle();
      localBundle.putString("key_game_friUin", str);
      QIPCClientHelper.getInstance().callServer("cm_game_module", "action_voice_switch", localBundle, null);
    }
  }
  
  public void d()
  {
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)getLayoutParams();
    if (localLayoutParams != null)
    {
      localLayoutParams.addRule(11);
      localLayoutParams.addRule(10);
      Resources localResources = ((Activity)this.jdField_a_of_type_MqqUtilWeakReference.get()).getResources();
      localLayoutParams.topMargin = ((int)localResources.getDimension(2131296518));
      localLayoutParams.rightMargin = ((int)localResources.getDimension(2131296517));
      QLog.d("cmframe_CmGameFloatView", 1, "[handleMessage] MSG_RESET_TOP_MENU reset");
      setLayoutParams(localLayoutParams);
    }
  }
  
  public void onClick(View paramView)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam == null) {}
    Object localObject1;
    label112:
    do
    {
      for (;;)
      {
        EventCollector.getInstance().onViewClicked(paramView);
        return;
        switch (paramView.getId())
        {
        default: 
          break;
        case 2131363963: 
          if ((this.jdField_a_of_type_ComTencentMobileqqApolloProcessDataCmGameLauncher != null) && (this.jdField_a_of_type_ComTencentMobileqqApolloProcessDataCmGameLauncher.a())) {
            break label1033;
          }
          QLog.d("cmframe_CmGameFloatView", 1, "game not running, finish");
          localObject1 = (Activity)this.jdField_a_of_type_MqqUtilWeakReference.get();
          if ((localObject1 != null) && (!((Activity)localObject1).isFinishing())) {
            ((Activity)localObject1).finish();
          }
          if (this.jdField_a_of_type_MqqUtilWeakReference != null)
          {
            localObject1 = (Activity)this.jdField_a_of_type_MqqUtilWeakReference.get();
            if ((localObject1 != null) && ((localObject1 instanceof ApolloGameActivity))) {
              ((ApolloGameActivity)localObject1).g();
            }
          }
          break;
        case 2131364051: 
          if (this.jdField_a_of_type_ComTencentMobileqqApolloProcessDataCmGameLauncher != null)
          {
            if (!this.jdField_a_of_type_ComTencentMobileqqApolloProcessDataCmGameLauncher.c()) {
              break label185;
            }
            QLog.e("cmframe_CmGameFloatView", 1, "onClick mGameLauncher.isDisableMoreMenu():true");
          }
          break;
        }
      }
    } while ((this.jdField_a_of_type_ComTencentWidgetActionSheet != null) && (this.jdField_a_of_type_ComTencentWidgetActionSheet.isShowing()));
    label185:
    label234:
    int j;
    if (this.jdField_a_of_type_ComTencentWidgetActionSheet == null) {
      if (a())
      {
        this.jdField_a_of_type_ComTencentWidgetActionSheet = ((ActionSheet)ActionSheetHelper.a(this.jdField_a_of_type_ComTencentMobileqqApolloProcessDataCmGameLauncher.a(), null));
        if (QLog.isColorLevel()) {
          QLog.d("cmframe_CmGameFloatView", 2, new Object[] { "isWhiteUsr:", Boolean.valueOf(this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.isWhiteUsr) });
        }
        if (this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.pushItem == null) {
          break label1328;
        }
        localObject1 = HardCodeUtil.a(2131702122);
        if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.pushItem.content)) {
          localObject1 = this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.pushItem.content;
        }
        if (this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.pushItem.is_show_red != 1) {
          break label813;
        }
        this.jdField_a_of_type_ComTencentWidgetActionSheet.addButtonWithRightIcon((String)localObject1, 2130850830, 0);
        label343:
        this.e = 0;
        this.jdField_a_of_type_AndroidUtilSparseIntArray.put(0, 6);
        j = this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.src;
        int k = this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.gameId;
        localObject1 = this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.pushItem.msg_id;
        if (this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.pushItem.is_show_red != 1) {
          break label834;
        }
        i = 1;
        label403:
        VipUtils.a(null, "cmshow", "Apollo", "exporePromoteInUnversialFrame", j, 0, new String[] { String.valueOf(k), localObject1, String.valueOf(i) });
      }
    }
    label550:
    label813:
    label1328:
    for (int i = 1;; i = 0)
    {
      j = i;
      if (!this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.disableMinGame)
      {
        j = this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.enter;
        if ((j == 0) || (j == 1) || (j == 7))
        {
          this.jdField_a_of_type_ComTencentWidgetActionSheet.addButton(2131690144, 0);
          label490:
          this.jdField_a_of_type_AndroidUtilSparseIntArray.put(i, 0);
          j = i + 1;
        }
      }
      else
      {
        i = j;
        if (this.jdField_b_of_type_Boolean)
        {
          i = j;
          if (this.jdField_d_of_type_Boolean)
          {
            i = j;
            if (!this.jdField_a_of_type_Boolean)
            {
              if (!this.jdField_c_of_type_Boolean) {
                break label853;
              }
              this.jdField_a_of_type_ComTencentWidgetActionSheet.addButton(HardCodeUtil.a(2131702127));
              this.jdField_b_of_type_Int = j;
              this.jdField_a_of_type_AndroidUtilSparseIntArray.put(j, 5);
              i = j + 1;
            }
          }
        }
        this.jdField_a_of_type_ComTencentWidgetActionSheet.addButton(2131690147, 0);
        localObject1 = this.jdField_a_of_type_AndroidUtilSparseIntArray;
        j = i + 1;
        ((SparseIntArray)localObject1).put(i, 1);
        this.jdField_a_of_type_ComTencentWidgetActionSheet.addButton(2131690139, 0);
        localObject1 = this.jdField_a_of_type_AndroidUtilSparseIntArray;
        i = j + 1;
        ((SparseIntArray)localObject1).put(j, 3);
        if ((this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.game == null) || (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.game.name))) {
          break label869;
        }
        this.jdField_a_of_type_ComTencentWidgetActionSheet.addButton(HardCodeUtil.a(2131702124) + this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.game.name, 0);
        label690:
        localObject1 = this.jdField_a_of_type_AndroidUtilSparseIntArray;
        j = i + 1;
        ((SparseIntArray)localObject1).put(i, 2);
        localObject1 = BaseApplicationImpl.getApplication().getSharedPreferences("cmgame_sp", 0);
        if (this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.isWhiteUsr) {
          break label883;
        }
        this.jdField_a_of_type_ComTencentWidgetActionSheet.addCancelButton(2131690800);
        this.jdField_a_of_type_ComTencentWidgetActionSheet.setOnButtonClickListener(this.jdField_a_of_type_ComTencentWidgetActionSheet$OnButtonClickListener);
      }
      label834:
      label853:
      label869:
      label883:
      do
      {
        do
        {
          this.jdField_a_of_type_ComTencentWidgetActionSheet.show();
          VipUtils.a(null, "cmshow", "Apollo", "more_info", 0, 0, new String[] { String.valueOf(this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.gameId) });
          break;
          this.jdField_a_of_type_ComTencentWidgetActionSheet = ((ActionSheet)ActionSheetHelper.b(this.jdField_a_of_type_ComTencentMobileqqApolloProcessDataCmGameLauncher.a(), null));
          break label234;
          this.jdField_a_of_type_ComTencentWidgetActionSheet.addButton(this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.pushItem.content, 0);
          break label343;
          i = 0;
          break label403;
          this.jdField_a_of_type_ComTencentWidgetActionSheet.addButton(2131690145, 0);
          break label490;
          this.jdField_a_of_type_ComTencentWidgetActionSheet.addButton(HardCodeUtil.a(2131702126));
          break label550;
          this.jdField_a_of_type_ComTencentWidgetActionSheet.addButton(2131690146, 0);
          break label690;
          bool = ((SharedPreferences)localObject1).getBoolean("game_debug_tool_switch", true);
          localObject1 = this.jdField_a_of_type_ComTencentWidgetActionSheet;
          if (bool) {}
          for (i = 2131690142;; i = 2131690143)
          {
            ((ActionSheet)localObject1).addButton(i, 0);
            this.f = j;
            this.jdField_a_of_type_AndroidUtilSparseIntArray.put(j, 9);
            break;
          }
        } while (!this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.isWhiteUsr);
        localObject1 = BaseApplicationImpl.getApplication().getSharedPreferences("cmgame_sp", 0);
      } while (this.f < 0);
      boolean bool = ((SharedPreferences)localObject1).getBoolean("game_debug_tool_switch", true);
      localObject1 = this.jdField_a_of_type_ComTencentWidgetActionSheet;
      j = this.f;
      Object localObject2 = getResources();
      if (bool) {}
      for (i = 2131690142;; i = 2131690143)
      {
        ((ActionSheet)localObject1).updateButton(j, ((Resources)localObject2).getString(i));
        break;
      }
      QLog.d("cmframe_CmGameFloatView", 1, "notify game");
      if (!b())
      {
        if (this.jdField_a_of_type_ComTencentMobileqqApolloGameOnGameMenuListener != null) {
          this.jdField_a_of_type_ComTencentMobileqqApolloGameOnGameMenuListener.a();
        }
        this.jdField_a_of_type_ComTencentMobileqqApolloProcessDataCmGameLauncher.i();
        if ((this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam == null) || ((this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.commFlag & 0x1) == 0))
        {
          this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.sendEmptyMessageDelayed(102, 1000L);
          break label112;
        }
        this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.sendEmptyMessageDelayed(102, 5000L);
        QLog.i("cmframe_CmGameFloatView", 1, "comm flag bit0 is 1.");
        break label112;
      }
      this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.sendEmptyMessage(111);
      break label112;
      if (this.jdField_a_of_type_Boolean)
      {
        if (!CmGameUtil.e())
        {
          b();
          break;
        }
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d("cmframe_CmGameFloatView", 2, "[onClick] click audio button too fast.");
        break;
      }
      localObject2 = (String)this.jdField_a_of_type_ComTencentMobileqqApolloViewFrameGifView.getTag();
      if (this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam != null) {}
      for (localObject1 = String.valueOf(this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.gameId);; localObject1 = "")
      {
        VipUtils.a(null, "cmshow", "Apollo", "clickpacket", 0, 0, new String[] { localObject1 });
        if (TextUtils.isEmpty((CharSequence)localObject2)) {
          break;
        }
        localObject1 = super.getContext();
        Intent localIntent = new Intent((Context)localObject1, QQBrowserActivity.class);
        localIntent.putExtra("url", (String)localObject2);
        localIntent.putExtra("portraitOnly", true);
        localIntent.putExtra("hide_operation_bar", true);
        localIntent.putExtra("hide_more_button", true);
        ((Context)localObject1).startActivity(localIntent);
        break;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.process.ui.framework.CmGameFloatView
 * JD-Core Version:    0.7.0.1
 */