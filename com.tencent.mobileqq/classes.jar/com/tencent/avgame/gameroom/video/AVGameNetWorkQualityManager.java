package com.tencent.avgame.gameroom.video;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import com.tencent.avgame.business.observer.ObserverCenter;
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
    this.jdField_a_of_type_AndroidViewView = paramView.findViewById(2131363162);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131373978));
    this.jdField_a_of_type_AndroidViewView.setVisibility(8);
    this.jdField_b_of_type_AndroidOsHandler = new Handler();
    this.jdField_a_of_type_AndroidOsHandler = AVGameHandler.a().a();
    this.jdField_a_of_type_ComTencentAvgameGameroomVideoAVGameNetWorkQualityManager$UpdateNetWorkStatusRunnable = new AVGameNetWorkQualityManager.UpdateNetWorkStatusRunnable(this, null);
    d();
  }
  
  public static int a()
  {
    int i = -1;
    if (AppNetConnInfo.isWifiConn()) {
      i = 1;
    }
    while (!AppNetConnInfo.isMobileConn()) {
      return i;
    }
    switch (AppNetConnInfo.getMobileInfo())
    {
    default: 
      return -1;
    case 1: 
      return 2;
    case 2: 
      return 3;
    case 3: 
      return 4;
    }
    return 5;
  }
  
  private int a(int paramInt)
  {
    if ((paramInt >= this.jdField_a_of_type_ArrayOfInt[0]) && (paramInt <= this.jdField_a_of_type_ArrayOfInt[1])) {
      return 1;
    }
    if ((paramInt > this.jdField_a_of_type_ArrayOfInt[1]) && (paramInt <= this.jdField_a_of_type_ArrayOfInt[2])) {
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
      this.jdField_a_of_type_AndroidViewView.setBackgroundDrawable(a(2130838857));
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setText(paramInt2 + "ms");
      return;
      if (paramInt1 == 2) {
        this.jdField_a_of_type_AndroidViewView.setBackgroundDrawable(a(2130838855));
      } else if (paramInt1 == 3) {
        this.jdField_a_of_type_AndroidViewView.setBackgroundDrawable(a(2130838853));
      }
    }
  }
  
  private boolean a(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AVGameNetWorkQualityManager", 2, "verifyRTTInfo value:=" + paramString);
    }
    if (TextUtils.isEmpty(paramString)) {}
    do
    {
      return false;
      paramString = paramString.split("\\|");
    } while ((paramString == null) || (paramString.length < 2));
    this.jdField_b_of_type_Int = this.c;
    this.jdField_a_of_type_Long = this.c;
    try
    {
      this.c = Integer.valueOf(paramString[0]).intValue();
      this.jdField_b_of_type_Long = Long.parseLong(paramString[1]);
      return true;
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        paramString.printStackTrace();
      }
    }
  }
  
  private void b(int paramInt1, int paramInt2)
  {
    if (paramInt1 == 1) {
      this.jdField_a_of_type_AndroidViewView.setBackgroundDrawable(a(2130838861));
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setText(paramInt2 + "ms");
      return;
      if (paramInt1 == 2) {
        this.jdField_a_of_type_AndroidViewView.setBackgroundDrawable(a(2130838860));
      } else if (paramInt1 == 3) {
        this.jdField_a_of_type_AndroidViewView.setBackgroundDrawable(a(2130838859));
      }
    }
  }
  
  private void d()
  {
    if (this.jdField_a_of_type_ComTencentAvgameGameroomVideoAVGameNetWorkQualityManager$MyNetObserver == null)
    {
      this.jdField_a_of_type_ComTencentAvgameGameroomVideoAVGameNetWorkQualityManager$MyNetObserver = new AVGameNetWorkQualityManager.MyNetObserver(this);
      ObserverCenter.a().a(this.jdField_a_of_type_ComTencentAvgameGameroomVideoAVGameNetWorkQualityManager$MyNetObserver, true);
    }
  }
  
  private void e()
  {
    this.jdField_a_of_type_JavaLangString = AVGameBusinessCtrl.b().a();
    if (!a(this.jdField_a_of_type_JavaLangString)) {
      return;
    }
    this.jdField_b_of_type_AndroidOsHandler.removeCallbacks(this.jdField_a_of_type_ComTencentAvgameGameroomVideoAVGameNetWorkQualityManager$UpdateNetWorkStatusRunnable);
    this.jdField_b_of_type_AndroidOsHandler.post(this.jdField_a_of_type_ComTencentAvgameGameroomVideoAVGameNetWorkQualityManager$UpdateNetWorkStatusRunnable);
  }
  
  private void f()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AVGameNetWorkQualityManager", 2, "mCurrentNetWorkStatus, [" + this.jdField_a_of_type_Int + "<--mCurrentRTTValue>" + this.c + "]");
    }
    if ((!this.jdField_a_of_type_Boolean) || (!this.jdField_b_of_type_Boolean)) {
      return;
    }
    int j = a(this.c);
    int i;
    if (this.c >= 0)
    {
      i = Math.min(this.c, 999);
      if ((this.jdField_a_of_type_Long <= 0L) || (this.jdField_b_of_type_Long <= 0L) || (this.jdField_b_of_type_Long - this.jdField_a_of_type_Long >= 1000L)) {
        break label202;
      }
      j = 3;
      i = 999;
    }
    label202:
    for (;;)
    {
      this.jdField_a_of_type_Int = a();
      if (this.jdField_a_of_type_Int == -1) {
        g();
      }
      for (;;)
      {
        this.jdField_a_of_type_AndroidViewView.setVisibility(0);
        return;
        i = 999;
        break;
        if (this.jdField_a_of_type_Int == 1) {
          b(j, i);
        } else if (this.jdField_a_of_type_Int >= 2) {
          a(j, i);
        }
      }
    }
  }
  
  private void g()
  {
    this.jdField_a_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_AndroidWidgetTextView.getResources().getString(2131690478));
    this.jdField_a_of_type_AndroidViewView.setBackgroundDrawable(a(2130838852));
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.avgame.gameroom.video.AVGameNetWorkQualityManager
 * JD-Core Version:    0.7.0.1
 */