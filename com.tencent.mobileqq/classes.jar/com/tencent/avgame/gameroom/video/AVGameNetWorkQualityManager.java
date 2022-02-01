package com.tencent.avgame.gameroom.video;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.avgame.business.observer.ObserverCenter;
import com.tencent.avgame.gameroom.GameRoomViewLayoutParamsDef;
import com.tencent.avgame.qav.AVGameBusinessCtrl;
import com.tencent.avgame.ui.AVGameHandler;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.qphone.base.util.QLog;

public class AVGameNetWorkQualityManager
{
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long;
  private final Handler jdField_a_of_type_AndroidOsHandler;
  private View jdField_a_of_type_AndroidViewView;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private AVGameNetWorkQualityManager.MyNetObserver jdField_a_of_type_ComTencentAvgameGameroomVideoAVGameNetWorkQualityManager$MyNetObserver;
  private final AVGameNetWorkQualityManager.NetWorkQulityCheckRunnable jdField_a_of_type_ComTencentAvgameGameroomVideoAVGameNetWorkQualityManager$NetWorkQulityCheckRunnable = new AVGameNetWorkQualityManager.NetWorkQulityCheckRunnable(this, null);
  private final AVGameNetWorkQualityManager.UpdateNetWorkStatusRunnable jdField_a_of_type_ComTencentAvgameGameroomVideoAVGameNetWorkQualityManager$UpdateNetWorkStatusRunnable;
  private String jdField_a_of_type_JavaLangString;
  private boolean jdField_a_of_type_Boolean = false;
  private final int[] jdField_a_of_type_ArrayOfInt = { 0, 150, 300 };
  private int jdField_b_of_type_Int;
  private long jdField_b_of_type_Long;
  private final Handler jdField_b_of_type_AndroidOsHandler;
  private boolean jdField_b_of_type_Boolean = true;
  private int c;
  
  public AVGameNetWorkQualityManager(View paramView)
  {
    this.jdField_a_of_type_AndroidViewView = paramView.findViewById(2131363102);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131373550));
    this.jdField_a_of_type_AndroidViewView.setVisibility(8);
    this.jdField_b_of_type_AndroidOsHandler = new Handler();
    this.jdField_a_of_type_AndroidOsHandler = AVGameHandler.a().a();
    this.jdField_a_of_type_ComTencentAvgameGameroomVideoAVGameNetWorkQualityManager$UpdateNetWorkStatusRunnable = new AVGameNetWorkQualityManager.UpdateNetWorkStatusRunnable(this, null);
    e();
  }
  
  public static int a()
  {
    boolean bool = AppNetConnInfo.isWifiConn();
    int i = 4;
    if (bool) {
      return 1;
    }
    if (AppNetConnInfo.isMobileConn())
    {
      int j = AppNetConnInfo.getMobileInfo();
      if (j != 1)
      {
        if (j != 2)
        {
          if (j == 3) {
            return i;
          }
          if (j == 4) {
            return 5;
          }
        }
        else
        {
          return 3;
        }
      }
      else {
        return 2;
      }
    }
    i = -1;
    return i;
  }
  
  private int a(int paramInt)
  {
    int[] arrayOfInt = this.jdField_a_of_type_ArrayOfInt;
    if ((paramInt >= arrayOfInt[0]) && (paramInt <= arrayOfInt[1])) {
      return 1;
    }
    arrayOfInt = this.jdField_a_of_type_ArrayOfInt;
    if ((paramInt > arrayOfInt[1]) && (paramInt <= arrayOfInt[2])) {
      return 2;
    }
    return 3;
  }
  
  private Drawable a(int paramInt)
  {
    return this.jdField_a_of_type_AndroidViewView.getResources().getDrawable(paramInt);
  }
  
  private void a(int paramInt1, int paramInt2)
  {
    if (paramInt1 == 1) {
      this.jdField_a_of_type_AndroidViewView.setBackgroundDrawable(a(2130838644));
    } else if (paramInt1 == 2) {
      this.jdField_a_of_type_AndroidViewView.setBackgroundDrawable(a(2130838643));
    } else if (paramInt1 == 3) {
      this.jdField_a_of_type_AndroidViewView.setBackgroundDrawable(a(2130838642));
    }
    TextView localTextView = this.jdField_a_of_type_AndroidWidgetTextView;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramInt2);
    localStringBuilder.append("ms");
    localTextView.setText(localStringBuilder.toString());
  }
  
  private boolean a(String paramString)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("verifyRTTInfo value:=");
      localStringBuilder.append(paramString);
      QLog.d("AVGameNetWorkQualityManager", 2, localStringBuilder.toString());
    }
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    paramString = paramString.split("\\|");
    if (paramString != null)
    {
      if (paramString.length < 2) {
        return false;
      }
      int i = this.c;
      this.jdField_b_of_type_Int = i;
      this.jdField_a_of_type_Long = i;
      try
      {
        this.c = Integer.valueOf(paramString[0]).intValue();
        this.jdField_b_of_type_Long = Long.parseLong(paramString[1]);
        return true;
      }
      catch (Exception paramString)
      {
        paramString.printStackTrace();
        return true;
      }
    }
    return false;
  }
  
  private void b(int paramInt1, int paramInt2)
  {
    if (paramInt1 == 1) {
      this.jdField_a_of_type_AndroidViewView.setBackgroundDrawable(a(2130838647));
    } else if (paramInt1 == 2) {
      this.jdField_a_of_type_AndroidViewView.setBackgroundDrawable(a(2130838646));
    } else if (paramInt1 == 3) {
      this.jdField_a_of_type_AndroidViewView.setBackgroundDrawable(a(2130838645));
    }
    TextView localTextView = this.jdField_a_of_type_AndroidWidgetTextView;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramInt2);
    localStringBuilder.append("ms");
    localTextView.setText(localStringBuilder.toString());
  }
  
  private void e()
  {
    if (this.jdField_a_of_type_ComTencentAvgameGameroomVideoAVGameNetWorkQualityManager$MyNetObserver == null)
    {
      this.jdField_a_of_type_ComTencentAvgameGameroomVideoAVGameNetWorkQualityManager$MyNetObserver = new AVGameNetWorkQualityManager.MyNetObserver(this);
      ObserverCenter.a().a(this.jdField_a_of_type_ComTencentAvgameGameroomVideoAVGameNetWorkQualityManager$MyNetObserver, true);
    }
  }
  
  private void f()
  {
    this.jdField_a_of_type_JavaLangString = AVGameBusinessCtrl.b().a();
    if (!a(this.jdField_a_of_type_JavaLangString)) {
      return;
    }
    this.jdField_b_of_type_AndroidOsHandler.removeCallbacks(this.jdField_a_of_type_ComTencentAvgameGameroomVideoAVGameNetWorkQualityManager$UpdateNetWorkStatusRunnable);
    this.jdField_b_of_type_AndroidOsHandler.post(this.jdField_a_of_type_ComTencentAvgameGameroomVideoAVGameNetWorkQualityManager$UpdateNetWorkStatusRunnable);
  }
  
  private void g()
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("mCurrentNetWorkStatus, [");
      localStringBuilder.append(this.jdField_a_of_type_Int);
      localStringBuilder.append("<--mCurrentRTTValue>");
      localStringBuilder.append(this.c);
      localStringBuilder.append("]");
      QLog.d("AVGameNetWorkQualityManager", 2, localStringBuilder.toString());
    }
    if (this.jdField_a_of_type_Boolean)
    {
      if (!this.jdField_b_of_type_Boolean) {
        return;
      }
      int m = a(this.c);
      int i = this.c;
      if (i >= 0) {
        i = Math.min(i, 999);
      } else {
        i = 999;
      }
      long l1 = this.jdField_a_of_type_Long;
      int k = m;
      int j = i;
      if (l1 > 0L)
      {
        long l2 = this.jdField_b_of_type_Long;
        k = m;
        j = i;
        if (l2 > 0L)
        {
          k = m;
          j = i;
          if (l2 - l1 < 1000L)
          {
            k = 3;
            j = 999;
          }
        }
      }
      this.jdField_a_of_type_Int = a();
      i = this.jdField_a_of_type_Int;
      if (i == -1) {
        h();
      } else if (i == 1) {
        b(k, j);
      } else if (i >= 2) {
        a(k, j);
      }
      this.jdField_a_of_type_AndroidViewView.setVisibility(0);
    }
  }
  
  private void h()
  {
    TextView localTextView = this.jdField_a_of_type_AndroidWidgetTextView;
    localTextView.setText(localTextView.getResources().getString(2131690402));
    this.jdField_a_of_type_AndroidViewView.setBackgroundDrawable(a(2130838641));
  }
  
  public void a()
  {
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacks(this.jdField_a_of_type_ComTencentAvgameGameroomVideoAVGameNetWorkQualityManager$NetWorkQulityCheckRunnable);
    this.jdField_a_of_type_AndroidOsHandler.postDelayed(this.jdField_a_of_type_ComTencentAvgameGameroomVideoAVGameNetWorkQualityManager$NetWorkQulityCheckRunnable, 500L);
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_b_of_type_Boolean = paramBoolean;
    if (!this.jdField_b_of_type_Boolean)
    {
      this.jdField_a_of_type_AndroidViewView.setVisibility(8);
      this.jdField_a_of_type_AndroidOsHandler.removeCallbacks(this.jdField_a_of_type_ComTencentAvgameGameroomVideoAVGameNetWorkQualityManager$NetWorkQulityCheckRunnable);
      this.jdField_b_of_type_AndroidOsHandler.removeCallbacks(this.jdField_a_of_type_ComTencentAvgameGameroomVideoAVGameNetWorkQualityManager$UpdateNetWorkStatusRunnable);
      return;
    }
    this.jdField_a_of_type_AndroidViewView.setVisibility(0);
  }
  
  public void b()
  {
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacks(this.jdField_a_of_type_ComTencentAvgameGameroomVideoAVGameNetWorkQualityManager$NetWorkQulityCheckRunnable);
    this.jdField_a_of_type_AndroidOsHandler.postDelayed(this.jdField_a_of_type_ComTencentAvgameGameroomVideoAVGameNetWorkQualityManager$NetWorkQulityCheckRunnable, 0L);
  }
  
  public void c()
  {
    this.jdField_b_of_type_Int = 0;
    this.jdField_a_of_type_Long = 0L;
    this.c = 0;
    this.jdField_b_of_type_Long = 0L;
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacks(this.jdField_a_of_type_ComTencentAvgameGameroomVideoAVGameNetWorkQualityManager$NetWorkQulityCheckRunnable);
    if (this.jdField_a_of_type_ComTencentAvgameGameroomVideoAVGameNetWorkQualityManager$MyNetObserver != null)
    {
      ObserverCenter.a().b(this.jdField_a_of_type_ComTencentAvgameGameroomVideoAVGameNetWorkQualityManager$MyNetObserver);
      this.jdField_a_of_type_ComTencentAvgameGameroomVideoAVGameNetWorkQualityManager$MyNetObserver = null;
    }
    this.jdField_b_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
  }
  
  public void d()
  {
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.jdField_a_of_type_AndroidViewView.getLayoutParams();
    localLayoutParams.leftMargin = GameRoomViewLayoutParamsDef.f;
    localLayoutParams.bottomMargin = GameRoomViewLayoutParamsDef.f;
    localLayoutParams.width = GameRoomViewLayoutParamsDef.m;
    localLayoutParams.height = GameRoomViewLayoutParamsDef.e;
    this.jdField_a_of_type_AndroidWidgetTextView.setTextSize(GameRoomViewLayoutParamsDef.l);
    this.jdField_a_of_type_AndroidWidgetTextView.getLayoutParams().height = GameRoomViewLayoutParamsDef.o;
    this.jdField_a_of_type_AndroidWidgetTextView.setPadding(0, GameRoomViewLayoutParamsDef.n, 0, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.avgame.gameroom.video.AVGameNetWorkQualityManager
 * JD-Core Version:    0.7.0.1
 */