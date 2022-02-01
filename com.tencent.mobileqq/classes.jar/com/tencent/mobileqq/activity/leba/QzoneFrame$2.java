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
import cooperation.qzone.api.OnSwitchQzoneTabListener;
import cooperation.qzone.api.QZoneApiProxy;
import cooperation.qzone.api.QzoneFragmentImpl;

class QzoneFrame$2
  extends OnSwitchQzoneTabListener
{
  QzoneFrame$2(QzoneFrame paramQzoneFrame) {}
  
  public void onSwitch(int paramInt)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("onSwitch: ");
    ((StringBuilder)localObject).append(paramInt);
    QLog.d("QzoneFrame", 1, ((StringBuilder)localObject).toString());
    Fragment localFragment = QzoneFrame.b(this.a);
    if ((QzoneFrame.b(this.a) == QzoneFrame.a(this.a)) && (paramInt == 1)) {
      return;
    }
    if (QzoneFrame.c(this.a) == null)
    {
      localObject = this.a;
      QzoneFrame.a((QzoneFrame)localObject, QZoneApiProxy.createLebaFragment(((QzoneFrame)localObject).a(), (QQAppInterface)this.a.jdField_a_of_type_MqqAppAppRuntime, "com.qzone.feed.ui.activity.QQLebaExtendFeedFragment"));
    }
    else if ((QzoneFrame.b(this.a) == QzoneFrame.c(this.a)) && (paramInt == 2))
    {
      return;
    }
    if (QzoneFrame.a(this.a) == null)
    {
      localObject = this.a;
      QzoneFrame.a((QzoneFrame)localObject, (TextView)QzoneFrame.a((QzoneFrame)localObject).findViewById(2131369249));
    }
    Drawable localDrawable;
    if (QzoneFrame.b(this.a) == QzoneFrame.c(this.a))
    {
      localObject = this.a;
      QzoneFrame.b((QzoneFrame)localObject, QzoneFrame.a((QzoneFrame)localObject));
      ((QzoneFragmentImpl)QzoneFrame.a(this.a)).setTitleAlphaAndGetLastValue(QzoneFrame.a(this.a));
      localObject = "动态";
      localDrawable = null;
    }
    else
    {
      localObject = this.a;
      QzoneFrame.b((QzoneFrame)localObject, QzoneFrame.c((QzoneFrame)localObject));
      if (QzoneFrame.a(this.a) == null) {
        if (Build.VERSION.SDK_INT > 20)
        {
          localObject = this.a;
          QzoneFrame.a((QzoneFrame)localObject, ((QzoneFrame)localObject).a().getDrawable(2130845114));
        }
        else
        {
          localObject = this.a;
          QzoneFrame.a((QzoneFrame)localObject, ((QzoneFrame)localObject).a().getResources().getDrawable(2130845114));
        }
      }
      localObject = this.a;
      QzoneFrame.a((QzoneFrame)localObject, ((QzoneFragmentImpl)QzoneFrame.a((QzoneFrame)localObject)).setTitleAlphaAndGetLastValue(0));
      localDrawable = QzoneFrame.a(this.a);
      localObject = "暖说说";
    }
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
    if ((QzoneFrame.b(this.a) == QzoneFrame.c(this.a)) && ((QzoneFrame.c(this.a) instanceof QzoneFragmentImpl))) {
      if (QzoneFrame.a(this.a)) {
        QzoneFrame.a(this.a, false);
      } else {
        ((QzoneFragmentImpl)QzoneFrame.c(this.a)).forceRefresh();
      }
    }
    localFragment.onPause();
    localFragment.onStop();
    QzoneFrame.b(this.a).onStart();
    ((QzoneFragmentImpl)QzoneFrame.b(this.a)).resetReportFlag();
    QzoneFrame.b(this.a).onResume();
    QzoneFrame.b(this.a).removeView(localFragment.getView());
    QzoneFrame.b(this.a).addView(QzoneFrame.b(this.a).getView());
    if (Build.VERSION.SDK_INT > 15) {
      QzoneFrame.b(this.a).setBackground(localDrawable);
    } else {
      QzoneFrame.b(this.a).setBackgroundDrawable(localDrawable);
    }
    QzoneFrame.a(this.a).setText((CharSequence)localObject);
    if (QzoneFrame.b(this.a) == QzoneFrame.a(this.a))
    {
      ((QzoneFragmentImpl)QzoneFrame.a(this.a)).setRightButtonType(QzoneFrame.jdField_a_of_type_Int);
      return;
    }
    ((QzoneFragmentImpl)QzoneFrame.a(this.a)).setRightButtonType(QzoneFrame.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.leba.QzoneFrame.2
 * JD-Core Version:    0.7.0.1
 */