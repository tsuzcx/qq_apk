package com.tencent.mobileqq.apollo.utils;

import akro;
import aktr;
import alfo;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.JumpActivity;
import com.tencent.mobileqq.apollo.cmgame.CmGameStartChecker.StartCheckParam;
import com.tencent.mobileqq.apollo.store.ApolloGameActivity;
import com.tencent.mobileqq.data.ApolloGameData;
import com.tencent.qphone.base.util.QLog;

final class ApolloGameUtil$13
  implements Runnable
{
  ApolloGameUtil$13(int paramInt, String paramString, alfo paramalfo) {}
  
  public void run()
  {
    Object localObject1 = BaseApplicationImpl.getContext();
    try
    {
      Object localObject2 = akro.a(this.jdField_a_of_type_Int);
      if (localObject2 == null) {
        return;
      }
      Object localObject3 = ((aktr)localObject2).a();
      if ((localObject3 != null) && (((CmGameStartChecker.StartCheckParam)localObject3).game != null))
      {
        localObject3 = ((CmGameStartChecker.StartCheckParam)localObject3).game.name;
        Intent localIntent = new Intent((Context)localObject1, JumpActivity.class);
        localIntent.putExtra("jump_cm_game", true);
        localIntent.putExtra("jump_cm_game_id", this.jdField_a_of_type_Int);
        localIntent.putExtra("jump_cm_extendinfo", this.jdField_a_of_type_JavaLangString);
        localIntent.setFlags(337641472);
        localObject1 = null;
        Activity localActivity = ((aktr)localObject2).a();
        if ((localActivity instanceof ApolloGameActivity))
        {
          localObject2 = ((ApolloGameActivity)localActivity).a();
          localObject1 = localObject2;
          if (localObject2 == null) {
            localObject1 = ApolloUtil.a();
          }
        }
        ApolloGameUtil.a(localActivity, this.jdField_a_of_type_Int, localIntent, (String)localObject3, (Bitmap)localObject1, this.jdField_a_of_type_Alfo);
        return;
      }
    }
    catch (Exception localException)
    {
      QLog.e("ApolloGameUtil", 1, localException, new Object[0]);
      return;
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      QLog.e("ApolloGameUtil", 1, localOutOfMemoryError, new Object[0]);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.utils.ApolloGameUtil.13
 * JD-Core Version:    0.7.0.1
 */