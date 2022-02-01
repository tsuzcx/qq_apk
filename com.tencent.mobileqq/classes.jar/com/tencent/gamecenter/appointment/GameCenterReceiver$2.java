package com.tencent.gamecenter.appointment;

import aceg;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import auuc;
import bizh;
import bmwv;
import com.tencent.common.app.BaseApplicationImpl;
import cooperation.wadl.WadlProvider;
import cooperation.wadl.ipc.WadlParams;
import cooperation.wadl.ipc.WadlResult;
import java.util.Iterator;
import java.util.List;

class GameCenterReceiver$2
  implements Runnable
{
  GameCenterReceiver$2(GameCenterReceiver paramGameCenterReceiver, Intent paramIntent) {}
  
  public void run()
  {
    switch (this.a.getIntExtra("key_event_id", -1))
    {
    }
    do
    {
      do
      {
        do
        {
          do
          {
            do
            {
              do
              {
                do
                {
                  do
                  {
                    return;
                    bizh.a().a();
                    return;
                    synchronized (this.this$0.a)
                    {
                      Object localObject2 = this.a.getStringExtra("key_appid");
                      Object localObject4 = this.a.getStringExtra("key_pkg_name");
                      if ((!TextUtils.isEmpty((CharSequence)localObject2)) && (!TextUtils.isEmpty((CharSequence)localObject4)))
                      {
                        localObject2 = new WadlResult(new WadlParams((String)localObject2, (String)localObject4));
                        ((WadlResult)localObject2).b = 12;
                        localObject4 = this.this$0.a.iterator();
                        if (((Iterator)localObject4).hasNext()) {
                          ((aceg)((Iterator)localObject4).next()).c((WadlResult)localObject2);
                        }
                      }
                    }
                    return;
                  } while ((BaseApplicationImpl.sProcessId != 1) || (!WadlProvider.jdField_a_of_type_Boolean));
                  ??? = bmwv.b(this.a.getStringExtra("appId"), WadlProvider.jdField_a_of_type_JavaLangString);
                } while (TextUtils.isEmpty((CharSequence)???));
                Bundle localBundle = this.a.getExtras();
                localBundle.putString("via", "provider");
                localBundle.putInt("flags", 39);
                auuc.a(localBundle, (String)???, false, 0);
                return;
              } while ((BaseApplicationImpl.sProcessId != 1) || (!WadlProvider.jdField_a_of_type_Boolean));
              ??? = bmwv.b(this.a.getStringExtra("appId"), WadlProvider.jdField_a_of_type_JavaLangString);
            } while (TextUtils.isEmpty((CharSequence)???));
            auuc.a(0, (String)???);
            return;
          } while ((BaseApplicationImpl.sProcessId != 1) || (!WadlProvider.jdField_a_of_type_Boolean));
          ??? = bmwv.b(this.a.getStringExtra("appId"), WadlProvider.jdField_a_of_type_JavaLangString);
        } while (TextUtils.isEmpty((CharSequence)???));
        ??? = new WadlParams((String)???, this.a.getStringExtra("pkgName"));
        ((WadlParams)???).p = "biz_src_zf_games";
        auuc.a((WadlParams)???);
        return;
      } while ((BaseApplicationImpl.sProcessId != 1) || (!WadlProvider.jdField_a_of_type_Boolean));
      ??? = bmwv.b(this.a.getStringExtra("appId"), WadlProvider.jdField_a_of_type_JavaLangString);
    } while (TextUtils.isEmpty((CharSequence)???));
    auuc.b(0, (String)???);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.gamecenter.appointment.GameCenterReceiver.2
 * JD-Core Version:    0.7.0.1
 */