package com.tencent.mobileqq.activity.leba;

import android.app.Fragment;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.api.QZoneApiProxy;
import cooperation.qzone.api.QzoneFragmentImpl;

class QzoneFrame$2
  extends QzoneFrame.OnSwitchQzoneTabListener
{
  QzoneFrame$2(QzoneFrame paramQzoneFrame)
  {
    super(paramQzoneFrame);
  }
  
  public void a(int paramInt)
  {
    QLog.d("QzoneFrame", 1, "onSwitch: " + paramInt);
    Fragment localFragment = QzoneFrame.b(this.a);
    if ((QzoneFrame.b(this.a) == QzoneFrame.a(this.a)) && (paramInt == 1)) {
      return;
    }
    String str;
    Drawable localDrawable;
    if (QzoneFrame.c(this.a) == null)
    {
      QzoneFrame.a(this.a, QZoneApiProxy.createLebaFragment(this.a.a(), (QQAppInterface)this.a.jdField_a_of_type_MqqAppAppRuntime, "com.qzone.feed.ui.activity.QQLebaExtendFeedFragment"));
      if (QzoneFrame.a(this.a) == null) {
        QzoneFrame.a(this.a, (TextView)QzoneFrame.a(this.a).findViewById(2131369534));
      }
      if (QzoneFrame.b(this.a) != QzoneFrame.c(this.a)) {
        break label493;
      }
      QzoneFrame.b(this.a, QzoneFrame.a(this.a));
      ((QzoneFragmentImpl)QzoneFrame.a(this.a)).setTitleAlphaAndGetLastValue(QzoneFrame.a(this.a));
      str = "动态";
      localDrawable = null;
      if (QzoneFrame.b(this.a) != null)
      {
        QzoneFrame.b(this.a).onAttach(this.a.a());
        QzoneFrame.b(this.a).onCreate(null);
        if (QzoneFrame.b(this.a).getView() == null)
        {
          QzoneFrame.b(this.a).onCreateView(LayoutInflater.from(this.a.a()), null, null);
          QzoneFrame.b(this.a).onActivityCreated(null);
        }
      }
      if ((QzoneFrame.b(this.a) == QzoneFrame.c(this.a)) && ((QzoneFrame.c(this.a) instanceof QzoneFragmentImpl)))
      {
        if (!QzoneFrame.a(this.a)) {
          break label610;
        }
        QzoneFrame.a(this.a, false);
      }
      label324:
      localFragment.onPause();
      localFragment.onStop();
      QzoneFrame.b(this.a).onStart();
      ((QzoneFragmentImpl)QzoneFrame.b(this.a)).resetReportFlag();
      QzoneFrame.b(this.a).onResume();
      QzoneFrame.b(this.a).removeView(localFragment.getView());
      QzoneFrame.b(this.a).addView(QzoneFrame.b(this.a).getView());
      if (Build.VERSION.SDK_INT <= 15) {
        break label628;
      }
      QzoneFrame.b(this.a).setBackground(localDrawable);
    }
    for (;;)
    {
      QzoneFrame.a(this.a).setText(str);
      if (QzoneFrame.b(this.a) != QzoneFrame.a(this.a)) {
        break label642;
      }
      ((QzoneFragmentImpl)QzoneFrame.a(this.a)).setRightButtonType(QzoneFrame.jdField_a_of_type_Int);
      return;
      if ((QzoneFrame.b(this.a) != QzoneFrame.c(this.a)) || (paramInt != 2)) {
        break;
      }
      return;
      label493:
      QzoneFrame.b(this.a, QzoneFrame.c(this.a));
      if (QzoneFrame.a(this.a) == null)
      {
        if (Build.VERSION.SDK_INT <= 20) {
          break label584;
        }
        QzoneFrame.a(this.a, this.a.a().getDrawable(2130845224));
      }
      for (;;)
      {
        QzoneFrame.a(this.a, ((QzoneFragmentImpl)QzoneFrame.a(this.a)).setTitleAlphaAndGetLastValue(0));
        localDrawable = QzoneFrame.a(this.a);
        str = "暖说说";
        break;
        label584:
        QzoneFrame.a(this.a, this.a.a().getResources().getDrawable(2130845224));
      }
      label610:
      ((QzoneFragmentImpl)QzoneFrame.c(this.a)).forceRefresh();
      break label324;
      label628:
      QzoneFrame.b(this.a).setBackgroundDrawable(localDrawable);
    }
    label642:
    ((QzoneFragmentImpl)QzoneFrame.a(this.a)).setRightButtonType(QzoneFrame.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.leba.QzoneFrame.2
 * JD-Core Version:    0.7.0.1
 */