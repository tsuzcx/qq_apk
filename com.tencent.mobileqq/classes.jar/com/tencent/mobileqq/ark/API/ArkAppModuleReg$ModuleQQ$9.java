package com.tencent.mobileqq.ark.API;

import adll;
import alpf;
import alsb;
import alta;
import altd;
import alub;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import bbcv;
import bbga;
import bbgg;
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
  public ArkAppModuleReg$ModuleQQ$9(alpf paramalpf, String paramString1, String paramString2, String paramString3, long paramLong) {}
  
  public void run()
  {
    Object localObject1;
    if (this.jdField_a_of_type_JavaLangString.equals("fullscreen"))
    {
      altd.a(null, this.this$0.jdField_a_of_type_JavaLangString, "FullScreenOrH5Show", 0, 0, 0L, 0L, 0L, "", "");
      if ((BaseActivity.sTopActivity instanceof FragmentActivity))
      {
        localObject1 = (FragmentActivity)BaseActivity.sTopActivity;
        altd.a(null, this.this$0.jdField_a_of_type_JavaLangString, "FullScreenOrH5ShowForAI", 0, 0, 0L, 0L, 0L, "", "");
        ArkFullScreenAppActivity.a((Context)localObject1, this.this$0.b, this.b, "0.0.0.1", this.c, alta.a(), null, 0);
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
            localObject3 = new alsb();
            ((alsb)localObject3).jdField_a_of_type_JavaLangString = this.this$0.b;
            ((alsb)localObject3).d = this.this$0.c;
            ((alsb)localObject3).f = this.c;
            ((alsb)localObject3).b = this.b;
            ((List)localObject2).add(localObject3);
            ((BaseChatPie)localObject1).a.a((List)localObject2, 0);
            return;
            if (!this.jdField_a_of_type_JavaLangString.equals("popup")) {
              break;
            }
            localObject1 = BaseActivity.sTopActivity;
          } while (!(localObject1 instanceof FragmentActivity));
          Object localObject2 = bbga.a(this.this$0.b, this.b, "0.0.0.1", this.c, alta.a(), null, null);
          if (alpf.a(this.this$0) != null)
          {
            localObject3 = (bbgg)alpf.a(this.this$0).get();
            if ((localObject3 != null) && (((bbgg)localObject3).isShowing())) {
              ((bbgg)localObject3).dismiss();
            }
          }
          localObject2 = bbcv.a((Context)localObject1, null, (Bundle)localObject2);
          ((bbgg)localObject2).setNegativeButton(2131690596, null);
          ((bbgg)localObject2).setPositiveButton(2131694793, null);
          alpf.a(this.this$0, new WeakReference(localObject2));
          ((bbgg)localObject2).show();
          altd.a(((BaseActivity)localObject1).app, "ShowView", this.this$0.jdField_a_of_type_JavaLangString, null, altd.i, 0, 0);
          return;
          if (!this.jdField_a_of_type_JavaLangString.equals("card")) {
            break;
          }
          localObject1 = ark.arkGetContainer(this.jdField_a_of_type_Long);
          QLog.d("ArkOpenView", 1, "OpenView card container=" + localObject1);
        } while (localObject1 == null);
        localObject1 = (adll)adll.a((ark.Container)localObject1).get();
      } while (localObject1 == null);
      ((adll)localObject1).a(this.b, this.c);
      return;
    } while ((!this.jdField_a_of_type_JavaLangString.equals("bottom_card")) || (!(BaseActivity.sTopActivity instanceof FragmentActivity)));
    ArkFullScreenAppActivity.a((FragmentActivity)BaseActivity.sTopActivity, "com.tencent.cmgame.intent", "GameCard", this.c);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.ark.API.ArkAppModuleReg.ModuleQQ.9
 * JD-Core Version:    0.7.0.1
 */