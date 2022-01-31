package com.tencent.av.smallscreen;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import baig;
import com.tencent.av.VideoController;
import com.tencent.qphone.base.util.QLog;
import kvq;
import lou;
import lox;
import loz;

public class SmallScreenVideoController$MyVideoObserver$1
  implements Runnable
{
  public SmallScreenVideoController$MyVideoObserver$1(lox paramlox, String paramString, boolean paramBoolean) {}
  
  public void run()
  {
    Object localObject2 = null;
    Object localObject1 = baig.a(this.jdField_a_of_type_Lox.a.jdField_a_of_type_AndroidContentContext);
    if (!((SharedPreferences)localObject1).getBoolean("kick_out_self", false))
    {
      if ((this.jdField_a_of_type_Lox.a.c != 1) && (this.jdField_a_of_type_Lox.a.c != 2)) {
        break label170;
      }
      if ((this.jdField_a_of_type_Lox.a.jdField_a_of_type_JavaLangString != null) && (this.jdField_a_of_type_JavaLangString != null) && (this.jdField_a_of_type_Lox.a.jdField_a_of_type_JavaLangString.equals(this.jdField_a_of_type_JavaLangString)))
      {
        this.jdField_a_of_type_Lox.a.b = this.jdField_a_of_type_Boolean;
        this.jdField_a_of_type_Lox.a.d();
      }
      if (this.jdField_a_of_type_Lox.a.jdField_a_of_type_Loz != null)
      {
        localObject1 = ((SharedPreferences)localObject1).edit();
        ((SharedPreferences.Editor)localObject1).putInt("video_position", this.jdField_a_of_type_Lox.a.jdField_a_of_type_Loz.g());
        ((SharedPreferences.Editor)localObject1).commit();
      }
    }
    label170:
    label306:
    do
    {
      for (;;)
      {
        return;
        if ((this.jdField_a_of_type_Lox.a.c != 3) && (this.jdField_a_of_type_Lox.a.c != 4)) {
          break;
        }
        if (this.jdField_a_of_type_Lox.a.jdField_a_of_type_ComTencentAvVideoController == null)
        {
          localObject1 = null;
          if (localObject1 != null) {
            break label297;
          }
        }
        for (localObject1 = localObject2;; localObject1 = String.valueOf(((kvq)localObject1).g))
        {
          if ((localObject1 == null) || (this.jdField_a_of_type_JavaLangString == null) || (!((String)localObject1).equals(this.jdField_a_of_type_JavaLangString))) {
            break label306;
          }
          if (QLog.isColorLevel()) {
            QLog.d("SmallScreenVideoController", 2, "[random room owner] onDestroyUI finish");
          }
          this.jdField_a_of_type_Lox.a.b = this.jdField_a_of_type_Boolean;
          this.jdField_a_of_type_Lox.a.d();
          return;
          localObject1 = this.jdField_a_of_type_Lox.a.jdField_a_of_type_ComTencentAvVideoController.a();
          break;
        }
      }
    } while ((this.jdField_a_of_type_Lox.a.c != 0) || (!this.jdField_a_of_type_Lox.a.jdField_a_of_type_Boolean) || ((this.jdField_a_of_type_Lox.a.d != 1) && (this.jdField_a_of_type_Lox.a.d != 2)));
    label297:
    this.jdField_a_of_type_Lox.a.b = this.jdField_a_of_type_Boolean;
    this.jdField_a_of_type_Lox.a.d();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.av.smallscreen.SmallScreenVideoController.MyVideoObserver.1
 * JD-Core Version:    0.7.0.1
 */