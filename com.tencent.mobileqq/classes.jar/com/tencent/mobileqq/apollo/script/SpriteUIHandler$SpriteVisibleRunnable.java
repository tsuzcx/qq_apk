package com.tencent.mobileqq.apollo.script;

import akra;
import alar;
import alaw;
import alba;
import albf;
import albi;
import alnq;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;

class SpriteUIHandler$SpriteVisibleRunnable
  implements Runnable
{
  private alba jdField_a_of_type_Alba;
  private String jdField_a_of_type_JavaLangString;
  private boolean jdField_a_of_type_Boolean;
  private boolean b;
  
  public SpriteUIHandler$SpriteVisibleRunnable(alba paramalba, boolean paramBoolean1, boolean paramBoolean2, String paramString)
  {
    this.b = paramBoolean1;
    this.jdField_a_of_type_Boolean = paramBoolean2;
    this.jdField_a_of_type_Alba = paramalba;
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public void run()
  {
    if (this.jdField_a_of_type_Alba == null)
    {
      QLog.e("cmshow_scripted_SpriteUIHandler", 1, "[onDoubleTap], mContext is null.");
      return;
    }
    Object localObject1;
    int i;
    if (this.jdField_a_of_type_Boolean)
    {
      localObject1 = this.jdField_a_of_type_Alba;
      if (this.b)
      {
        i = 1;
        label37:
        ((alba)localObject1).d = i;
        this.jdField_a_of_type_Alba.a(this.b);
      }
    }
    Object localObject2;
    for (;;)
    {
      localObject1 = this.jdField_a_of_type_Alba.a();
      localObject2 = this.jdField_a_of_type_Alba.a();
      if (localObject2 == null) {
        break;
      }
      QLog.d("cmshow_scripted_SpriteUIHandler", 1, new Object[] { "[showOrHideSprite], isHide:", Boolean.valueOf(this.b), ",from:", this.jdField_a_of_type_JavaLangString, ",surfaceView:", localObject1, ",canInit:", Boolean.valueOf(this.jdField_a_of_type_Alba.jdField_a_of_type_Boolean), ",isViweReady:", Boolean.valueOf(this.jdField_a_of_type_Alba.d()) });
      if (this.b) {
        break label367;
      }
      if ((localObject1 != null) || (this.jdField_a_of_type_Alba.jdField_a_of_type_Boolean)) {
        break label220;
      }
      QLog.i("cmshow_scripted_SpriteUIHandler", 1, "surfaceView is going to be created in basechatpie, pls wait.");
      return;
      i = 0;
      break label37;
      if (this.jdField_a_of_type_JavaLangString != null) {
        this.jdField_a_of_type_Alba.a(this.jdField_a_of_type_JavaLangString, this.b);
      }
    }
    label220:
    if ((localObject1 != null) && (!this.jdField_a_of_type_Alba.d()))
    {
      QLog.i("cmshow_scripted_SpriteUIHandler", 1, "surfaceView is being created but NOT yet ready, pls wait.");
      return;
    }
    Object localObject3 = this.jdField_a_of_type_Alba.a();
    if ((localObject3 != null) && (((BaseChatPie)localObject3).a != null) && (((BaseChatPie)localObject3).a.c))
    {
      QLog.i("cmshow_scripted_SpriteUIHandler", 1, "want to show apollo but AIO finish now");
      return;
    }
    if ((localObject1 != null) && (this.jdField_a_of_type_Alba.d())) {
      ((albf)((QQAppInterface)localObject2).getManager(249)).a(this.jdField_a_of_type_Alba.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Alba.jdField_a_of_type_Int);
    }
    for (;;)
    {
      ThreadManager.getUIHandler().post(new SpriteUIHandler.SpriteVisibleRunnable.1(this, (akra)localObject1));
      return;
      if ((localObject3 != null) && (this.jdField_a_of_type_Alba.jdField_a_of_type_Boolean))
      {
        ((BaseChatPie)localObject3).d();
        continue;
        label367:
        localObject3 = albi.a((QQAppInterface)localObject2);
        if (localObject3 != null) {
          ((alar)localObject3).b(2);
        }
        localObject2 = ((albf)((QQAppInterface)localObject2).getManager(249)).a();
        if (localObject2 != null) {
          ((alaw)localObject2).e();
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.script.SpriteUIHandler.SpriteVisibleRunnable
 * JD-Core Version:    0.7.0.1
 */