package com.tencent.mobileqq.ark.API;

import agyw;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import apvx;
import apwn;
import aqax;
import aqbx;
import aqca;
import aqcy;
import bhlq;
import bhow;
import bhpc;
import com.tencent.ark.ark;
import com.tencent.ark.ark.Container;
import com.tencent.mobileqq.activity.ArkFullScreenAppActivity;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.ChatFragment;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

public class ArkAppQQModule$9
  implements Runnable
{
  public ArkAppQQModule$9(apwn paramapwn, String paramString1, String paramString2, String paramString3, long paramLong) {}
  
  public void run()
  {
    Object localObject1;
    if (this.jdField_a_of_type_JavaLangString.equals("fullscreen"))
    {
      aqca.a(null, this.this$0.jdField_a_of_type_JavaLangString, "FullScreenOrH5Show", 0, 0, 0L, 0L, 0L, "", "");
      localObject1 = apvx.a();
      if ((localObject1 instanceof FragmentActivity))
      {
        localObject1 = (FragmentActivity)localObject1;
        aqca.a(null, this.this$0.jdField_a_of_type_JavaLangString, "FullScreenOrH5ShowForAI", 0, 0, 0L, 0L, 0L, "", "");
        ArkFullScreenAppActivity.a((Context)localObject1, this.this$0.b, this.b, "0.0.0.1", this.c, aqbx.a(), null, 0);
      }
    }
    do
    {
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
                    localObject1 = apvx.a();
                  } while (!(localObject1 instanceof FragmentActivity));
                  localObject1 = (ChatFragment)((FragmentActivity)localObject1).getSupportFragmentManager().findFragmentByTag(ChatFragment.class.getName());
                } while (localObject1 == null);
                localObject1 = ((ChatFragment)localObject1).a();
              } while ((localObject1 == null) || (((BaseChatPie)localObject1).a == null));
              localObject2 = new ArrayList();
              localObject3 = new aqax();
              ((aqax)localObject3).jdField_a_of_type_JavaLangString = this.this$0.b;
              ((aqax)localObject3).d = this.this$0.c;
              ((aqax)localObject3).f = this.c;
              ((aqax)localObject3).b = this.b;
              ((List)localObject2).add(localObject3);
              ((BaseChatPie)localObject1).a.a((List)localObject2, 0);
              return;
              if (!this.jdField_a_of_type_JavaLangString.equals("popup")) {
                break;
              }
              localObject1 = apvx.a();
            } while (!(localObject1 instanceof FragmentActivity));
            Object localObject2 = bhow.a(this.this$0.b, this.b, "0.0.0.1", this.c, aqbx.a(), null, null);
            if (apwn.a(this.this$0) != null)
            {
              localObject3 = (bhpc)apwn.a(this.this$0).get();
              if ((localObject3 != null) && (((bhpc)localObject3).isShowing())) {
                ((bhpc)localObject3).dismiss();
              }
            }
            localObject1 = bhlq.a((Context)localObject1, null, (Bundle)localObject2);
            ((bhpc)localObject1).setNegativeButton(2131690580, null);
            ((bhpc)localObject1).setPositiveButton(2131694098, null);
            apwn.a(this.this$0, new WeakReference(localObject1));
            ((bhpc)localObject1).show();
            aqca.a(null, "ShowView", this.this$0.jdField_a_of_type_JavaLangString, null, aqca.i, 0, 0);
            return;
            if (!this.jdField_a_of_type_JavaLangString.equals("card")) {
              break;
            }
            localObject1 = ark.arkGetContainer(this.jdField_a_of_type_Long);
            QLog.d("ArkOpenView", 1, "OpenView card container=" + localObject1);
          } while (localObject1 == null);
          localObject1 = (agyw)agyw.a((ark.Container)localObject1).get();
        } while (localObject1 == null);
        ((agyw)localObject1).a(this.b, this.c);
        return;
      } while (!this.jdField_a_of_type_JavaLangString.equals("bottom_card"));
      localObject1 = apvx.a();
    } while (!(localObject1 instanceof FragmentActivity));
    ArkFullScreenAppActivity.a((FragmentActivity)localObject1, "com.tencent.cmgame.intent", "GameCard", this.c);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ark.API.ArkAppQQModule.9
 * JD-Core Version:    0.7.0.1
 */