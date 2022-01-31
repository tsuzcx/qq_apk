package com.tencent.mobileqq.apollo.script;

import aiuz;
import ajeq;
import ajev;
import ajez;
import ajfe;
import ajfh;
import ajro;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;

class SpriteUIHandler$SpriteVisibleRunnable
  implements Runnable
{
  private ajez jdField_a_of_type_Ajez;
  private String jdField_a_of_type_JavaLangString;
  private boolean jdField_a_of_type_Boolean;
  private boolean b;
  
  public SpriteUIHandler$SpriteVisibleRunnable(ajez paramajez, boolean paramBoolean1, boolean paramBoolean2, String paramString)
  {
    this.b = paramBoolean1;
    this.jdField_a_of_type_Boolean = paramBoolean2;
    this.jdField_a_of_type_Ajez = paramajez;
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public void run()
  {
    if (this.jdField_a_of_type_Ajez == null)
    {
      QLog.e("cmshow_scripted_SpriteUIHandler", 1, "[onDoubleTap], mContext is null.");
      return;
    }
    Object localObject1;
    int i;
    if (this.jdField_a_of_type_Boolean)
    {
      localObject1 = this.jdField_a_of_type_Ajez;
      if (this.b)
      {
        i = 1;
        label37:
        ((ajez)localObject1).d = i;
        this.jdField_a_of_type_Ajez.a(this.b);
      }
    }
    Object localObject2;
    for (;;)
    {
      localObject1 = this.jdField_a_of_type_Ajez.a();
      localObject2 = this.jdField_a_of_type_Ajez.a();
      if (localObject2 == null) {
        break;
      }
      QLog.d("cmshow_scripted_SpriteUIHandler", 1, new Object[] { "[showOrHideSprite], isHide:", Boolean.valueOf(this.b), ",from:", this.jdField_a_of_type_JavaLangString, ",surfaceView:", localObject1, ",canInit:", Boolean.valueOf(this.jdField_a_of_type_Ajez.jdField_a_of_type_Boolean), ",isViweReady:", Boolean.valueOf(this.jdField_a_of_type_Ajez.d()) });
      if (this.b) {
        break label367;
      }
      if ((localObject1 != null) || (this.jdField_a_of_type_Ajez.jdField_a_of_type_Boolean)) {
        break label220;
      }
      QLog.i("cmshow_scripted_SpriteUIHandler", 1, "surfaceView is going to be created in basechatpie, pls wait.");
      return;
      i = 0;
      break label37;
      if (this.jdField_a_of_type_JavaLangString != null) {
        this.jdField_a_of_type_Ajez.a(this.jdField_a_of_type_JavaLangString, this.b);
      }
    }
    label220:
    if ((localObject1 != null) && (!this.jdField_a_of_type_Ajez.d()))
    {
      QLog.i("cmshow_scripted_SpriteUIHandler", 1, "surfaceView is being created but NOT yet ready, pls wait.");
      return;
    }
    Object localObject3 = this.jdField_a_of_type_Ajez.a();
    if ((localObject3 != null) && (((BaseChatPie)localObject3).a != null) && (((BaseChatPie)localObject3).a.c))
    {
      QLog.i("cmshow_scripted_SpriteUIHandler", 1, "want to show apollo but AIO finish now");
      return;
    }
    if ((localObject1 != null) && (this.jdField_a_of_type_Ajez.d())) {
      ((ajfe)((QQAppInterface)localObject2).getManager(249)).a(this.jdField_a_of_type_Ajez.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Ajez.jdField_a_of_type_Int);
    }
    for (;;)
    {
      ThreadManager.getUIHandler().post(new SpriteUIHandler.SpriteVisibleRunnable.1(this, (aiuz)localObject1));
      return;
      if ((localObject3 != null) && (this.jdField_a_of_type_Ajez.jdField_a_of_type_Boolean))
      {
        ((BaseChatPie)localObject3).d();
        continue;
        label367:
        localObject3 = ajfh.a((QQAppInterface)localObject2);
        if (localObject3 != null) {
          ((ajeq)localObject3).b(2);
        }
        localObject2 = ((ajfe)((QQAppInterface)localObject2).getManager(249)).a();
        if (localObject2 != null) {
          ((ajev)localObject2).e();
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.script.SpriteUIHandler.SpriteVisibleRunnable
 * JD-Core Version:    0.7.0.1
 */