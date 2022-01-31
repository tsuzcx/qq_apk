package com.tencent.mobileqq.ark.API;

import afdt;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import anfv;
import anis;
import anjs;
import anjv;
import ankt;
import bdcd;
import bdfk;
import bdfq;
import com.tencent.ark.ark;
import com.tencent.ark.ark.Container;
import com.tencent.mobileqq.activity.ArkFullScreenAppActivity;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.ChatFragment;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

public class ArkAppModuleReg$ModuleQQ$9
  implements Runnable
{
  public ArkAppModuleReg$ModuleQQ$9(anfv paramanfv, String paramString1, String paramString2, String paramString3, long paramLong) {}
  
  public void run()
  {
    Object localObject1;
    if (this.jdField_a_of_type_JavaLangString.equals("fullscreen"))
    {
      anjv.a(null, this.this$0.jdField_a_of_type_JavaLangString, "FullScreenOrH5Show", 0, 0, 0L, 0L, 0L, "", "");
      if ((BaseActivity.sTopActivity instanceof FragmentActivity))
      {
        localObject1 = (FragmentActivity)BaseActivity.sTopActivity;
        anjv.a(null, this.this$0.jdField_a_of_type_JavaLangString, "FullScreenOrH5ShowForAI", 0, 0, 0L, 0L, 0L, "", "");
        ArkFullScreenAppActivity.a((Context)localObject1, this.this$0.b, this.b, "0.0.0.1", this.c, anjs.a(), null, 0);
      }
    }
    do
    {
      do
      {
        do
        {
          Object localObject3;
          do
          {
            do
            {
              do
              {
                do
                {
                  return;
                  if (!this.jdField_a_of_type_JavaLangString.equals("input")) {
                    break;
                  }
                } while (!(BaseActivity.sTopActivity instanceof FragmentActivity));
                localObject1 = (ChatFragment)((FragmentActivity)BaseActivity.sTopActivity).getSupportFragmentManager().findFragmentByTag(ChatFragment.class.getName());
              } while (localObject1 == null);
              localObject1 = ((ChatFragment)localObject1).a();
            } while ((localObject1 == null) || (((BaseChatPie)localObject1).a == null));
            localObject2 = new ArrayList();
            localObject3 = new anis();
            ((anis)localObject3).jdField_a_of_type_JavaLangString = this.this$0.b;
            ((anis)localObject3).d = this.this$0.c;
            ((anis)localObject3).f = this.c;
            ((anis)localObject3).b = this.b;
            ((List)localObject2).add(localObject3);
            ((BaseChatPie)localObject1).a.a((List)localObject2, 0);
            return;
            if (!this.jdField_a_of_type_JavaLangString.equals("popup")) {
              break;
            }
            localObject1 = BaseActivity.sTopActivity;
          } while (!(localObject1 instanceof FragmentActivity));
          Object localObject2 = bdfk.a(this.this$0.b, this.b, "0.0.0.1", this.c, anjs.a(), null, null);
          if (anfv.a(this.this$0) != null)
          {
            localObject3 = (bdfq)anfv.a(this.this$0).get();
            if ((localObject3 != null) && (((bdfq)localObject3).isShowing())) {
              ((bdfq)localObject3).dismiss();
            }
          }
          localObject2 = bdcd.a((Context)localObject1, null, (Bundle)localObject2);
          ((bdfq)localObject2).setNegativeButton(2131690648, null);
          ((bdfq)localObject2).setPositiveButton(2131694951, null);
          anfv.a(this.this$0, new WeakReference(localObject2));
          ((bdfq)localObject2).show();
          anjv.a(((BaseActivity)localObject1).app, "ShowView", this.this$0.jdField_a_of_type_JavaLangString, null, anjv.i, 0, 0);
          return;
          if (!this.jdField_a_of_type_JavaLangString.equals("card")) {
            break;
          }
          localObject1 = ark.arkGetContainer(this.jdField_a_of_type_Long);
          QLog.d("ArkOpenView", 1, "OpenView card container=" + localObject1);
        } while (localObject1 == null);
        localObject1 = (afdt)afdt.a((ark.Container)localObject1).get();
      } while (localObject1 == null);
      ((afdt)localObject1).a(this.b, this.c);
      return;
    } while ((!this.jdField_a_of_type_JavaLangString.equals("bottom_card")) || (!(BaseActivity.sTopActivity instanceof FragmentActivity)));
    ArkFullScreenAppActivity.a((FragmentActivity)BaseActivity.sTopActivity, "com.tencent.cmgame.intent", "GameCard", this.c);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.ark.API.ArkAppModuleReg.ModuleQQ.9
 * JD-Core Version:    0.7.0.1
 */