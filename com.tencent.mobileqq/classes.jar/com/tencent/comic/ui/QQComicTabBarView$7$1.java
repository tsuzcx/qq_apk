package com.tencent.comic.ui;

import android.view.View;
import com.tencent.comic.utils.SimpleBiMap;
import com.tencent.mobileqq.redtouch.RedAppInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

class QQComicTabBarView$7$1
  implements Runnable
{
  QQComicTabBarView$7$1(QQComicTabBarView.7 param7, ArrayList paramArrayList, boolean paramBoolean, Map paramMap) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("WebViewTabBarView", 2, "start show red touch");
    }
    Object localObject2 = null;
    int i = this.jdField_a_of_type_ComTencentComicUiQQComicTabBarView$7.this$0.a();
    Object localObject1 = localObject2;
    if (i >= 0)
    {
      localObject1 = localObject2;
      if (i < QQComicTabBarView.a(this.jdField_a_of_type_ComTencentComicUiQQComicTabBarView$7.this$0))
      {
        localObject3 = QQComicTabBarView.a(this.jdField_a_of_type_ComTencentComicUiQQComicTabBarView$7.this$0, i).getTag(-3);
        localObject1 = localObject2;
        if ((localObject3 instanceof QQComicTabBarView.ViewHolder)) {
          localObject1 = ((QQComicTabBarView.ViewHolder)localObject3).a;
        }
      }
    }
    Object localObject3 = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    while (((Iterator)localObject3).hasNext())
    {
      String str = (String)((Iterator)localObject3).next();
      if (this.jdField_a_of_type_Boolean) {
        localObject2 = (RedTouchUI)this.jdField_a_of_type_ComTencentComicUiQQComicTabBarView$7.this$0.a.get(str);
      } else {
        localObject2 = (RedTouchUI)this.jdField_a_of_type_ComTencentComicUiQQComicTabBarView$7.this$0.a.get(this.jdField_a_of_type_ComTencentComicUiQQComicTabBarView$7.this$0.b.a(str));
      }
      if ((localObject2 != null) && (!localObject2.equals(localObject1)))
      {
        this.jdField_a_of_type_ComTencentComicUiQQComicTabBarView$7.this$0.a((RedTouchUI)localObject2, (RedAppInfo)this.jdField_a_of_type_JavaUtilMap.get(str), false);
      }
      else if (QLog.isColorLevel())
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("cannot find red touch on path: ");
        ((StringBuilder)localObject2).append(str);
        QLog.d("WebViewTabBarView", 2, ((StringBuilder)localObject2).toString());
      }
    }
    this.jdField_a_of_type_ComTencentComicUiQQComicTabBarView$7.this$0.b();
    if (QLog.isColorLevel()) {
      QLog.d("WebViewTabBarView", 2, "end show red touch");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.comic.ui.QQComicTabBarView.7.1
 * JD-Core Version:    0.7.0.1
 */