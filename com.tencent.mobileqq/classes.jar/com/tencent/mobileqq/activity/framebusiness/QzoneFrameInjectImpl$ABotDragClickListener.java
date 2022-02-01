package com.tencent.mobileqq.activity.framebusiness;

import android.view.View;
import com.tencent.mobileqq.app.FrameFragment.DragViewPunctureClickListener;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqprotect.qsec.QSecFramework;

public class QzoneFrameInjectImpl$ABotDragClickListener
  extends FrameFragment.DragViewPunctureClickListener
{
  public View a;
  public String a;
  public boolean a;
  
  public QzoneFrameInjectImpl$ABotDragClickListener(View paramView, String paramString)
  {
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_AndroidViewView = paramView;
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  private void a(ABotDragClickListener paramABotDragClickListener)
  {
    try
    {
      if (QSecFramework.a().a(1001).booleanValue())
      {
        Object localObject;
        if (paramABotDragClickListener.jdField_a_of_type_Boolean)
        {
          localObject = paramABotDragClickListener.jdField_a_of_type_AndroidViewView;
          QSecFramework.a().a(5, 0, 1, new Object[] { Integer.valueOf(80), localObject }, null);
          paramABotDragClickListener.jdField_a_of_type_Boolean = false;
          if (QLog.isColorLevel())
          {
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append("附近人机上报: lebaView onCreate, from=");
            ((StringBuilder)localObject).append(paramABotDragClickListener.jdField_a_of_type_JavaLangString);
            QLog.i("FrameControllerInjectImpl", 2, ((StringBuilder)localObject).toString());
          }
        }
        else
        {
          QSecFramework.a().a(5, 0, 2, new Object[] { Integer.valueOf(80), Integer.valueOf(1), Integer.valueOf(6), "lebaClick", null }, null);
          if (QLog.isColorLevel())
          {
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append("附近人机上报: lebaView onClick, from=");
            ((StringBuilder)localObject).append(paramABotDragClickListener.jdField_a_of_type_JavaLangString);
            QLog.i("FrameControllerInjectImpl", 2, ((StringBuilder)localObject).toString());
            return;
          }
        }
      }
    }
    catch (Exception paramABotDragClickListener)
    {
      if (QLog.isColorLevel()) {
        QLog.e("FrameControllerInjectImpl", 2, "ABotDragClickListener onClick exp=", paramABotDragClickListener);
      }
    }
  }
  
  public void onClick(View paramView)
  {
    super.onClick(paramView);
    a(this);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.framebusiness.QzoneFrameInjectImpl.ABotDragClickListener
 * JD-Core Version:    0.7.0.1
 */