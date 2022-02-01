import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.apollo.process.data.CmGameInitParams;
import com.tencent.mobileqq.apollo.utils.ApolloGameInvitation.1;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;

public class ankt
  implements DialogInterface.OnDismissListener, AdapterView.OnItemClickListener, bkzq
{
  private long jdField_a_of_type_Long;
  private amri jdField_a_of_type_Amri;
  private String jdField_a_of_type_JavaLangString;
  private WeakReference<Activity> jdField_a_of_type_JavaLangRefWeakReference;
  private String jdField_b_of_type_JavaLangString;
  private WeakReference<AppInterface> jdField_b_of_type_JavaLangRefWeakReference;
  private WeakReference<bkzi> c;
  
  public ankt(AppInterface paramAppInterface, Activity paramActivity)
  {
    try
    {
      this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramActivity);
      this.jdField_b_of_type_JavaLangRefWeakReference = new WeakReference(paramAppInterface);
      this.jdField_a_of_type_JavaLangString = "";
      return;
    }
    catch (Throwable paramAppInterface)
    {
      QLog.i("ApolloGameInvitation", 1, "[ApolloGameInvitation], errInfo->" + paramAppInterface.getMessage());
    }
  }
  
  private void a(int paramInt1, int paramInt2)
  {
    if (this.jdField_a_of_type_Amri != null)
    {
      amyo localamyo = amwn.a(this.jdField_a_of_type_Amri.jdField_a_of_type_Int);
      if (localamyo != null) {
        localamyo.a(paramInt1, paramInt2, 0, "");
      }
    }
  }
  
  public void OnClick(View paramView, int paramInt)
  {
    d();
  }
  
  public amri a(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("cmgame.sendmsg", 2, new Object[] { "[getGameMsgInfo], params:", paramString, ",app:", this.jdField_b_of_type_JavaLangRefWeakReference });
    }
    if ((TextUtils.isEmpty(paramString)) || (this.jdField_b_of_type_JavaLangRefWeakReference == null)) {
      paramString = null;
    }
    for (;;)
    {
      return paramString;
      if ((AppInterface)this.jdField_b_of_type_JavaLangRefWeakReference.get() == null) {
        return null;
      }
      try
      {
        amri localamri = new amri();
        paramString = new JSONObject(paramString);
        int i = paramString.optInt("gameId");
        long l = paramString.optLong("roomId");
        int j = paramString.optInt("gameMode");
        int k = paramString.optInt("activityId");
        Object localObject = amwn.a(i);
        if (localObject != null)
        {
          ((amyo)localObject).jdField_b_of_type_Int = k;
          localObject = ((amyo)localObject).a();
          if (localObject != null)
          {
            localamri.jdField_b_of_type_JavaLangString = ((CmGameInitParams)localObject).mChineseName;
            localamri.jdField_b_of_type_Int = ((CmGameInitParams)localObject).mActionId;
          }
        }
        if (0L == l) {
          QLog.w("cmgame.sendmsg", 1, "[getGameMsgInfo] roomId is invalid. gameId:" + i + ",gameMode:" + j);
        }
        localamri.jdField_c_of_type_Int = j;
        localamri.jdField_a_of_type_Long = l;
        localamri.jdField_a_of_type_Int = i;
        localamri.d = 3;
        localObject = amyv.a();
        if ((localObject != null) && (((amyv)localObject).a != null) && (0L != l)) {
          ((amyv)localObject).a.roomId = l;
        }
        localObject = paramString.optString("extendInfo");
        JSONObject localJSONObject = new JSONObject();
        paramString = localamri;
        if (!TextUtils.isEmpty((CharSequence)localObject))
        {
          localJSONObject.put("extendInfo", localObject);
          if (((String)localObject).length() >= 500)
          {
            QLog.w("cmgame.sendmsg", 1, "[getGameMsgInfo],extendInfo is too long, extendInfo:" + (String)localObject);
            return null;
          }
          localamri.jdField_c_of_type_JavaLangString = localJSONObject.toString();
          return localamri;
        }
      }
      catch (Throwable paramString)
      {
        QLog.e("ApolloGameInvitation", 1, paramString, new Object[0]);
      }
    }
    return null;
  }
  
  public void a()
  {
    bkzw localbkzw = null;
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(bkzw.a(0));
    localArrayList.add(bkzw.a(2));
    if (this.jdField_a_of_type_JavaLangRefWeakReference != null) {}
    for (Object localObject = (Activity)this.jdField_a_of_type_JavaLangRefWeakReference.get();; localObject = null)
    {
      if (localObject != null)
      {
        localbkzw = new bkzw((Context)localObject);
        localbkzw.a(localArrayList);
      }
      if (((this.c == null) || (this.c.get() == null)) && (localObject != null)) {
        this.c = new WeakReference(bkzw.a((Context)localObject, localbkzw, this, this, this, false));
      }
      if ((this.c != null) && (this.c.get() != null))
      {
        localObject = (bkzi)this.c.get();
        if ((localObject != null) && (!((bkzi)localObject).isShowing()))
        {
          ((bkzi)localObject).setOnDismissListener(this);
          ((bkzi)localObject).show();
        }
      }
      return;
    }
  }
  
  public void a(amri paramamri)
  {
    this.jdField_a_of_type_Amri = paramamri;
  }
  
  public void a(String paramString)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_JavaLangRefWeakReference == null) {}
    Activity localActivity;
    do
    {
      return;
      localActivity = (Activity)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    } while (localActivity == null);
    ankm.a(this.jdField_a_of_type_Amri, localActivity, 1);
  }
  
  public void c()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ApolloGameInvitation", 2, "[inviteWechatFriend]");
    }
    if (this.jdField_a_of_type_Amri == null)
    {
      QLog.e("ApolloGameInvitation", 1, "fail to invite wxFriend, mGameMsg is null.");
      return;
    }
    ThreadManager.post(new ApolloGameInvitation.1(this), 5, null, true);
  }
  
  public void d()
  {
    if ((this.c != null) && (this.c.get() != null))
    {
      bkzi localbkzi = (bkzi)this.c.get();
      if (localbkzi != null) {
        localbkzi.dismiss();
      }
    }
  }
  
  public void onDismiss(DialogInterface paramDialogInterface) {}
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    long l = System.currentTimeMillis();
    if (l - this.jdField_a_of_type_Long < 1000L) {}
    label165:
    for (;;)
    {
      EventCollector.getInstance().onItemClick(paramAdapterView, paramView, paramInt, paramLong);
      return;
      this.jdField_a_of_type_Long = l;
      d();
      if (paramLong == 2L)
      {
        if (QLog.isColorLevel()) {
          QLog.d("ApolloGameInvitation", 2, "ActionSheetAdapter.CHANNEL_WX_FRIEND is clicked.");
        }
        c();
      }
      for (int i = 1;; i = 0)
      {
        if ((this.jdField_b_of_type_JavaLangRefWeakReference == null) || (this.jdField_a_of_type_Amri == null) || ((AppInterface)this.jdField_b_of_type_JavaLangRefWeakReference.get() == null)) {
          break label165;
        }
        VipUtils.a(null, "cmshow", "Apollo", "invite_chose", i, 0, new String[] { Integer.toString(this.jdField_a_of_type_Amri.jdField_a_of_type_Int) });
        break;
        if (paramLong == 0L)
        {
          if (QLog.isColorLevel()) {
            QLog.d("ApolloGameInvitation", 2, "ActionSheetAdapter.CHANNEL_QQ is clicked.");
          }
          b();
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     ankt
 * JD-Core Version:    0.7.0.1
 */