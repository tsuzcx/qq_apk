import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.facetoface.Face2FaceAddFriendActivity;
import com.tencent.mobileqq.facetoface.SnowView;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class aomw
  extends Handler
{
  public aomw(Face2FaceAddFriendActivity paramFace2FaceAddFriendActivity) {}
  
  public void a(long paramLong)
  {
    removeMessages(0);
    sendMessageDelayed(obtainMessage(0), paramLong);
  }
  
  public void handleMessage(Message paramMessage)
  {
    boolean bool1 = false;
    int i;
    int k;
    Object localObject;
    boolean bool2;
    int j;
    switch (paramMessage.what)
    {
    case 1: 
    default: 
      return;
    case 0: 
      this.a.jdField_a_of_type_ComTencentMobileqqFacetofaceSnowView.invalidate();
      a(20L);
      return;
    case 2: 
      Face2FaceAddFriendActivity.a(this.a, (String)paramMessage.obj, paramMessage.arg1);
      return;
    case 3: 
      this.a.jdField_a_of_type_Aomx.a(1, false);
      return;
    case 4: 
      i = paramMessage.arg1;
      k = paramMessage.arg2;
      Bundle localBundle = paramMessage.getData();
      localObject = Boolean.valueOf(localBundle.getBoolean("key_data _ispush"));
      bool2 = localBundle.getBoolean("key_data _hasfriend");
      j = this.a.jdField_d_of_type_JavaUtilList.size();
      if (j >= 10) {
        j = 10;
      }
      break;
    }
    for (;;)
    {
      if (this.a.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.contains(paramMessage.obj))
      {
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d(Face2FaceAddFriendActivity.jdField_a_of_type_JavaLangString, 2, "push的数据是显示列表中已有数据");
        return;
      }
      if (i >= j) {
        break;
      }
      if (k == 1)
      {
        paramMessage = (aonr)paramMessage.obj;
        if (paramMessage.a)
        {
          i = 2;
          if (this.a.jdField_c_of_type_Int != j - 1) {
            break label1253;
          }
        }
      }
      label444:
      label1245:
      label1253:
      for (bool1 = true;; bool1 = false)
      {
        if (((Boolean)localObject).booleanValue())
        {
          this.a.jdField_a_of_type_Aomx.c();
          bool1 = true;
        }
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.d(Face2FaceAddFriendActivity.jdField_a_of_type_JavaLangString, 2, "show next isPush=" + localObject + "isNeedShake=" + bool1 + "currentFriendIndex=" + this.a.jdField_c_of_type_Int + "count=" + j);
          }
          this.a.jdField_a_of_type_Aomx.a(paramMessage, ((Boolean)localObject).booleanValue(), i, bool2, bool1);
          if (this.a.jdField_c_of_type_JavaUtilHashMap.containsKey(paramMessage.e))
          {
            this.a.jdField_c_of_type_JavaUtilHashMap.remove(paramMessage.e);
            this.a.jdField_c_of_type_JavaUtilHashMap.put(paramMessage.e, Integer.valueOf(i));
          }
          do
          {
            for (;;)
            {
              Face2FaceAddFriendActivity.b(this.a);
              return;
              i = 1;
              break;
              this.a.jdField_c_of_type_JavaUtilHashMap.put(paramMessage.e, Integer.valueOf(i));
            }
          } while (k != 2);
          paramMessage = (aonp)paramMessage.obj;
          if (this.a.b == 0)
          {
            if (!this.a.a(paramMessage.e)) {
              break label1245;
            }
            i = 2;
          }
          for (;;)
          {
            if (this.a.jdField_c_of_type_Int == j - 1) {
              bool1 = true;
            }
            if (((Boolean)localObject).booleanValue())
            {
              this.a.jdField_a_of_type_Aomx.c();
              bool1 = true;
            }
            this.a.jdField_a_of_type_Aomx.a(paramMessage, ((Boolean)localObject).booleanValue(), i, bool2, bool1);
            if (this.a.jdField_c_of_type_JavaUtilHashMap.containsKey(paramMessage.e))
            {
              this.a.jdField_c_of_type_JavaUtilHashMap.remove(paramMessage.e);
              this.a.jdField_c_of_type_JavaUtilHashMap.put(paramMessage.e, Integer.valueOf(i));
              break label444;
              if ((this.a.b != 1) || (((TroopManager)this.a.app.getManager(52)).b(this.a.jdField_d_of_type_JavaLangString, paramMessage.e) == null)) {
                break label1245;
              }
              i = 2;
              continue;
            }
            this.a.jdField_c_of_type_JavaUtilHashMap.put(paramMessage.e, Integer.valueOf(i));
            break label444;
            if (this.a.jdField_a_of_type_Ajzj == null) {
              break;
            }
            this.a.jdField_a_of_type_Ajzj.a(this.a.app.getCurrentAccountUin(), true);
            sendMessageDelayed(obtainMessage(5), Face2FaceAddFriendActivity.h);
            if (!QLog.isColorLevel()) {
              break;
            }
            QLog.d(Face2FaceAddFriendActivity.jdField_a_of_type_JavaLangString, 2, "FTF_MSG_SEND_HEARTBEAT=" + this.a.app.getCurrentAccountUin());
            return;
            if (Face2FaceAddFriendActivity.a(this.a)) {
              break;
            }
            paramMessage = this.a.getResources().getString(2131692270);
            bcql.a(this.a, 0, paramMessage, 0).b(this.a.getTitleBarHeight());
            return;
            this.a.a();
            return;
            this.a.jdField_a_of_type_Aomx.b();
            return;
            this.a.f();
            return;
            Face2FaceAddFriendActivity.a(this.a, (aonp)paramMessage.obj);
            return;
            Face2FaceAddFriendActivity.a(this.a, paramMessage.arg1);
            return;
            this.a.a((aonm)paramMessage.obj);
            return;
            paramMessage = this.a.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.iterator();
            while (paramMessage.hasNext())
            {
              localObject = (aonp)paramMessage.next();
              if ((((aonp)localObject).a == 1) && (Face2FaceAddFriendActivity.a(this.a, ((aonp)localObject).e))) {
                Face2FaceAddFriendActivity.a(this.a, ((aonp)localObject).a);
              } else if ((((aonp)localObject).a == 2) && (this.a.a(((aonp)localObject).e))) {
                Face2FaceAddFriendActivity.a(this.a, ((aonp)localObject).a);
              }
            }
            long l = this.a.o;
            paramMessage = new aonq(l + 2396794490L + "", "Member " + this.a.o, 1, 1, "");
            localObject = this.a;
            ((Face2FaceAddFriendActivity)localObject).o += 1;
            Face2FaceAddFriendActivity.a(this.a).a(paramMessage);
            Face2FaceAddFriendActivity.a(this.a).sendEmptyMessageDelayed(17, 300L);
            return;
            if (!(paramMessage.obj instanceof aonq)) {
              break;
            }
            paramMessage = (aonq)paramMessage.obj;
            this.a.a(paramMessage);
            return;
            if (!(paramMessage.obj instanceof aonq)) {
              break;
            }
            this.a.jdField_a_of_type_JavaUtilArrayList.add((aonq)paramMessage.obj);
            return;
            if (!(paramMessage.obj instanceof aonq)) {
              break;
            }
            Face2FaceAddFriendActivity.a(this.a).a((aonq)paramMessage.obj);
            return;
            bcql.a(this.a.app.getApplication(), 2131694610, 0).b(this.a.getTitleBarHeight());
            return;
            i = 1;
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aomw
 * JD-Core Version:    0.7.0.1
 */