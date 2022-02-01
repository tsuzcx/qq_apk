import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.together.writetogether.data.EditUserHistory;
import com.tencent.mobileqq.together.writetogether.statemachine.UserState;
import com.tencent.mobileqq.together.writetogether.websocket.msg.BaseWriteTogetherMsg.Type;
import com.tencent.mobileqq.together.writetogether.websocket.msg.ClientReadyRespMsg;
import com.tencent.mobileqq.together.writetogether.websocket.msg.OnPostResult;
import com.tencent.mobileqq.together.writetogether.websocket.msg.OnPostWrapper;
import com.tencent.mobileqq.together.writetogether.websocket.msg.UserLeaveMsg;
import com.tencent.mobileqq.together.writetogether.websocket.msg.UserLeaveMsg.Body;
import com.tencent.mobileqq.together.writetogether.websocket.msg.UserLeaveMsg.Notice;
import com.tencent.mobileqq.together.writetogether.websocket.msg.UserNewInfoMsg;
import com.tencent.mobileqq.together.writetogether.websocket.msg.UserNewInfoMsg.Body;
import com.tencent.mobileqq.together.writetogether.websocket.msg.UserNewInfoMsg.Notice;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;
import org.jetbrains.annotations.NotNull;

public class benp
  implements View.OnClickListener, bemm, benh, beni, beno
{
  private int jdField_a_of_type_Int;
  private BroadcastReceiver jdField_a_of_type_AndroidContentBroadcastReceiver;
  private Context jdField_a_of_type_AndroidContentContext;
  private benr jdField_a_of_type_Benr;
  private bens jdField_a_of_type_Bens;
  private beob jdField_a_of_type_Beob;
  private beoy jdField_a_of_type_Beoy;
  private bepz jdField_a_of_type_Bepz;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private boolean jdField_a_of_type_Boolean = true;
  
  public benp(QQAppInterface paramQQAppInterface, bepz parambepz, beob parambeob, int paramInt, Context paramContext)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_Bepz = parambepz;
    this.jdField_a_of_type_Beob = parambeob;
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_Beoy = new beoy(paramContext, paramInt, parambepz, parambeob);
    this.jdField_a_of_type_Beoy.a(this);
    paramQQAppInterface = paramQQAppInterface.getManager(377);
    if ((paramQQAppInterface instanceof beml)) {
      ((beml)paramQQAppInterface).a(this);
    }
    a(paramContext);
    this.jdField_a_of_type_Bepz.a().setOnClickListener(this);
  }
  
  private long a()
  {
    return System.currentTimeMillis();
  }
  
  @NotNull
  private String a(long paramLong, int paramInt, String paramString)
  {
    if (!bemv.a(a(), paramLong))
    {
      if (QLog.isColorLevel()) {
        QLog.d("UserStateController", 2, "not in same year. ");
      }
      if (b()) {
        return bemv.a(this.jdField_a_of_type_AndroidContentContext.getString(2131719150), paramLong);
      }
      return bemv.a(this.jdField_a_of_type_AndroidContentContext.getString(2131719151), paramString, paramLong);
    }
    if (paramInt > 604800000)
    {
      if (QLog.isColorLevel()) {
        QLog.d("UserStateController", 4, "last modified before " + paramInt / 604800000 + " 7 days");
      }
      if (b()) {
        return bemv.b(this.jdField_a_of_type_AndroidContentContext.getString(2131719148), paramLong);
      }
      return bemv.b(this.jdField_a_of_type_AndroidContentContext.getString(2131719149), paramString, paramLong);
    }
    if (paramInt > 86400000)
    {
      paramInt /= 86400000;
      if (QLog.isColorLevel()) {
        QLog.d("UserStateController", 4, "last modified before " + paramInt + " day");
      }
      if (b()) {
        return String.format(this.jdField_a_of_type_AndroidContentContext.getString(2131719142), new Object[] { Integer.valueOf(paramInt) });
      }
      return String.format(this.jdField_a_of_type_AndroidContentContext.getString(2131719143), new Object[] { paramString, Integer.valueOf(paramInt) });
    }
    if (paramInt > 3600000)
    {
      paramInt /= 3600000;
      if (QLog.isColorLevel()) {
        QLog.d("UserStateController", 4, "last modified before " + paramInt + " hour");
      }
      if (b()) {
        return String.format(this.jdField_a_of_type_AndroidContentContext.getString(2131719144), new Object[] { Integer.valueOf(paramInt) });
      }
      return String.format(this.jdField_a_of_type_AndroidContentContext.getString(2131719145), new Object[] { paramString, Integer.valueOf(paramInt) });
    }
    if (paramInt > 60000)
    {
      paramInt /= 60000;
      if (QLog.isColorLevel()) {
        QLog.d("UserStateController", 4, "last modified before " + paramInt + " min");
      }
      if (b()) {
        return String.format(this.jdField_a_of_type_AndroidContentContext.getString(2131719146), new Object[] { Integer.valueOf(paramInt) });
      }
      return String.format(this.jdField_a_of_type_AndroidContentContext.getString(2131719147), new Object[] { paramString, Integer.valueOf(paramInt) });
    }
    if (QLog.isColorLevel()) {
      QLog.d("UserStateController", 4, "last modified in 1 min");
    }
    if (b()) {
      return this.jdField_a_of_type_AndroidContentContext.getString(2131719140);
    }
    return String.format(this.jdField_a_of_type_AndroidContentContext.getString(2131719141), new Object[] { paramString });
  }
  
  private String a(String paramString)
  {
    return TextUtils.ellipsize(paramString, this.jdField_a_of_type_Bepz.b(), this.jdField_a_of_type_Bepz.a(), TextUtils.TruncateAt.END).toString();
  }
  
  private void a(Context paramContext)
  {
    this.jdField_a_of_type_AndroidContentBroadcastReceiver = new benq(this);
    IntentFilter localIntentFilter = new IntentFilter();
    localIntentFilter.addAction("android.intent.action.TIME_TICK");
    localIntentFilter.addAction("android.intent.action.TIMEZONE_CHANGED");
    localIntentFilter.addAction("android.intent.action.TIME_SET");
    paramContext.registerReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver, localIntentFilter);
  }
  
  private void a(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("UserStateController", 2, "[throwExceptionIfNeeded] reason: " + paramString);
    }
  }
  
  private void a(boolean paramBoolean, UserLeaveMsg paramUserLeaveMsg)
  {
    if ((!paramBoolean) || (paramUserLeaveMsg == null))
    {
      StringBuilder localStringBuilder = new StringBuilder().append("[onUserLeave] failed. msg :");
      if (paramUserLeaveMsg == null) {}
      for (paramUserLeaveMsg = "msg is null";; paramUserLeaveMsg = paramUserLeaveMsg.toJson())
      {
        QLog.e("UserStateController", 1, paramUserLeaveMsg);
        return;
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("UserStateController", 2, "[onUserLeave] msg: " + paramUserLeaveMsg.toJson());
    }
    paramUserLeaveMsg = (UserLeaveMsg.Body)paramUserLeaveMsg.body;
    if (paramUserLeaveMsg != null)
    {
      paramUserLeaveMsg = paramUserLeaveMsg.notice;
      if (paramUserLeaveMsg != null)
      {
        paramUserLeaveMsg = bemv.a(paramUserLeaveMsg.userId);
        this.jdField_a_of_type_Beob.a(paramUserLeaveMsg);
        return;
      }
      QLog.e("UserStateController", 1, "[onUserLeave] notice is null");
      return;
    }
    QLog.e("UserStateController", 1, "[onUserLeave] body is null");
  }
  
  private void a(boolean paramBoolean, UserNewInfoMsg paramUserNewInfoMsg)
  {
    if ((!paramBoolean) || (paramUserNewInfoMsg == null))
    {
      localObject = new StringBuilder().append("[onUserNewInfo] failed. msg: ");
      if (paramUserNewInfoMsg == null) {}
      for (paramUserNewInfoMsg = "msg is null";; paramUserNewInfoMsg = paramUserNewInfoMsg.toJson())
      {
        QLog.e("UserStateController", 1, paramUserNewInfoMsg);
        return;
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("UserStateController", 2, "[onUserNewInfo] msg: " + paramUserNewInfoMsg.toJson());
    }
    Object localObject = (UserNewInfoMsg.Body)paramUserNewInfoMsg.body;
    long l;
    if (localObject != null)
    {
      localObject = ((UserNewInfoMsg.Body)localObject).notice;
      if (localObject != null)
      {
        l = ((UserNewInfoMsg.Notice)localObject).aliveTime;
        if (l > 0L) {
          break label284;
        }
        l = a();
      }
    }
    label284:
    for (;;)
    {
      localObject = bemv.a(((UserNewInfoMsg.Notice)localObject).userId);
      beog localbeog = new beog();
      localbeog.a = bemv.a(((UserNewInfoMsg.Body)paramUserNewInfoMsg.body).notice.userId);
      localbeog.jdField_b_of_type_Int = bemo.jdField_a_of_type_ArrayOfInt[(((UserNewInfoMsg.Body)paramUserNewInfoMsg.body).notice.colorId % bemo.jdField_a_of_type_ArrayOfInt.length)];
      localbeog.jdField_b_of_type_JavaLangString = c(localbeog.a);
      if (QLog.isColorLevel()) {
        QLog.d("UserStateController", 2, "[onUserNewInfo] getNickName from ContactUtils: " + localbeog.jdField_b_of_type_JavaLangString);
      }
      this.jdField_a_of_type_Beob.a((String)localObject, l, localbeog);
      return;
      QLog.e("UserStateController", 1, "[onUserNewInfo] notice is null");
      return;
      QLog.e("UserStateController", 1, "[onUserNewInfo] body is null");
      return;
    }
  }
  
  private boolean a()
  {
    return this.jdField_a_of_type_Beoy.a() != UserState.NEW_DOC;
  }
  
  private String b(String paramString)
  {
    return TextUtils.ellipsize(paramString, this.jdField_a_of_type_Bepz.a(), this.jdField_a_of_type_Bepz.b(), TextUtils.TruncateAt.END).toString();
  }
  
  private void b(int paramInt1, int paramInt2)
  {
    boolean bool = true;
    if (paramInt1 >= paramInt2) {
      QLog.w("UserStateController", 1, "not reach the limit " + paramInt1 + ", with current " + paramInt2);
    }
    do
    {
      return;
      if (this.jdField_a_of_type_Beoy.a() != UserState.CHARACTERS_OVERSIZE) {
        this.jdField_a_of_type_Beoy.a(UserState.CHARACTERS_OVERSIZE);
      }
    } while (this.jdField_a_of_type_Beoy.a() != UserState.CHARACTERS_OVERSIZE);
    bepz localbepz = this.jdField_a_of_type_Bepz;
    String str = String.format(this.jdField_a_of_type_AndroidContentContext.getString(2131719152), new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt1) });
    if (this.jdField_a_of_type_Beoy.b() == UserState.NEW_DOC) {}
    for (;;)
    {
      localbepz.a(str, bool);
      return;
      bool = false;
    }
  }
  
  private boolean b()
  {
    String str1 = this.jdField_a_of_type_Beob.b();
    String str2 = this.jdField_a_of_type_Beob.a();
    if ((TextUtils.isEmpty(str2)) || (TextUtils.isEmpty(str1))) {
      return true;
    }
    return str1.equals(str2);
  }
  
  private String c(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      paramString = "";
    }
    String str1;
    do
    {
      return paramString;
      String str2 = d(paramString);
      str1 = str2;
      if (!TextUtils.isEmpty(str2)) {
        break;
      }
      str1 = this.jdField_a_of_type_Beob.a(paramString);
    } while (TextUtils.isEmpty(str1));
    return str1;
  }
  
  private String d(String paramString)
  {
    return bhlg.h(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Beob.d(), paramString);
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("UserStateController", 4, "[onCommitStart]");
    }
    if (a())
    {
      if (this.jdField_a_of_type_Beoy.a() == UserState.ALERT) {
        this.jdField_a_of_type_Beoy.a(UserState.COMMIT_WHILE_ALERT);
      }
      if ((this.jdField_a_of_type_Beoy.a() == UserState.LAST_EDIT) || (this.jdField_a_of_type_Beoy.a() == UserState.LAST_SAVE)) {
        this.jdField_a_of_type_Beoy.a(UserState.SAVING);
      }
    }
  }
  
  public void a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("UserStateController", 4, "[onCommitComplete]");
    }
    this.jdField_a_of_type_Beob.a(a());
    this.jdField_a_of_type_Beob.b(this.jdField_a_of_type_Beob.b());
    if (a())
    {
      if (this.jdField_a_of_type_Beoy.a() == UserState.COMMIT_WHILE_ALERT) {
        this.jdField_a_of_type_Beoy.a(UserState.ACCEPT_WHILE_ALERT);
      }
      if (this.jdField_a_of_type_Beoy.a() == UserState.SAVING) {
        this.jdField_a_of_type_Beoy.a(UserState.LAST_SAVE);
      }
      if (this.jdField_a_of_type_Beoy.a() == UserState.LAST_SAVE) {
        this.jdField_a_of_type_Beoy.a(1);
      }
    }
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    benr localbenr;
    if (paramInt1 < paramInt2)
    {
      b(paramInt1, paramInt2);
      if (this.jdField_a_of_type_Benr != null)
      {
        localbenr = this.jdField_a_of_type_Benr;
        if (paramInt1 >= paramInt2) {
          break label92;
        }
      }
    }
    label92:
    for (boolean bool = true;; bool = false)
    {
      localbenr.a(bool);
      return;
      if (this.jdField_a_of_type_Beoy.a() != UserState.CHARACTERS_OVERSIZE) {
        break;
      }
      if (this.jdField_a_of_type_Beoy.b() == UserState.NEW_DOC)
      {
        this.jdField_a_of_type_Beoy.a(UserState.NEW_DOC);
        break;
      }
      this.jdField_a_of_type_Beoy.a(UserState.SAVING);
      break;
    }
  }
  
  public void a(int paramInt, String paramString)
  {
    switch (paramInt)
    {
    default: 
      return;
    case 40401: 
      b(this.jdField_a_of_type_Beob.a(), this.jdField_a_of_type_Beob.a().a.length());
      return;
    case -1: 
      this.jdField_a_of_type_Beoy.a(UserState.NET_ERR);
      return;
    case -2: 
      this.jdField_a_of_type_Beoy.a(UserState.NET_AVAIL);
      return;
    case 65020: 
      this.jdField_a_of_type_Beoy.a(UserState.GAG, paramString);
      return;
    case 65019: 
    case 65022: 
      this.jdField_a_of_type_Beoy.a(UserState.COMMIT_ERR);
      return;
    }
    this.jdField_a_of_type_Beoy.a(UserState.SANCTION);
  }
  
  public void a(benr parambenr)
  {
    this.jdField_a_of_type_Benr = parambenr;
  }
  
  public void a(bens parambens)
  {
    this.jdField_a_of_type_Bens = parambens;
  }
  
  public void a(BaseWriteTogetherMsg.Type paramType, boolean paramBoolean, Object paramObject)
  {
    if ((paramType == BaseWriteTogetherMsg.Type.USER_NEWINFO) && ((paramObject instanceof UserNewInfoMsg)))
    {
      paramType = (UserNewInfoMsg)paramObject;
      if (this.jdField_a_of_type_Bens != null) {
        this.jdField_a_of_type_Bens.a(paramBoolean, paramType);
      }
      a(paramBoolean, paramType);
    }
    do
    {
      do
      {
        return;
        if ((paramType == BaseWriteTogetherMsg.Type.USER_LEAVE) && ((paramObject instanceof UserLeaveMsg)))
        {
          a(paramBoolean, (UserLeaveMsg)paramObject);
          return;
        }
      } while (paramType != BaseWriteTogetherMsg.Type.CLIENT_READY);
      paramType = ((OnPostWrapper)((ClientReadyRespMsg)paramObject).body).onpost;
      if (paramType.result == 60010)
      {
        this.jdField_a_of_type_Beoy.a(UserState.ROOM_FULL);
        return;
      }
    } while ((!paramBoolean) || (paramType.result != 0) || (this.jdField_a_of_type_Beoy.a() == UserState.ROOM_AVAILABLE) || (this.jdField_a_of_type_Beoy.a() != UserState.ROOM_FULL));
    this.jdField_a_of_type_Beoy.a(UserState.ROOM_AVAILABLE);
  }
  
  public void a(String paramString, List<String> paramList, boolean paramBoolean)
  {
    if ((TextUtils.isEmpty(paramString)) || (paramList == null)) {
      return;
    }
    ArrayList localArrayList = new ArrayList(paramList);
    int j = localArrayList.size();
    if (!paramBoolean) {
      localArrayList.remove(paramString);
    }
    paramList = new StringBuilder();
    if (!paramBoolean)
    {
      paramString = a(c(paramString));
      paramList.append(paramString).append("发起");
      if (QLog.isColorLevel()) {
        QLog.d("UserStateController", 2, "[onPartChange] get owner nick name: " + paramString);
      }
    }
    TextPaint localTextPaint;
    int i;
    Object localObject;
    label192:
    label208:
    float f1;
    if (localArrayList.size() != 0)
    {
      if (!paramBoolean) {
        paramList.append("，");
      }
      localTextPaint = this.jdField_a_of_type_Bepz.b();
      if (j > 2)
      {
        i = 1;
        localObject = new StringBuilder();
        if (i == 0) {
          break label406;
        }
        paramString = "等" + j + "人";
        localObject = ((StringBuilder)localObject).append(paramString);
        if (!paramBoolean) {
          break label413;
        }
        paramString = "正在输入";
        localObject = paramString;
        f1 = this.jdField_a_of_type_Bepz.c();
        float f2 = localTextPaint.measureText(bemo.jdField_a_of_type_JavaLangCharacter + paramList.toString());
        float f3 = localTextPaint.measureText((String)localObject);
        j = 3;
        f1 = f1 - f2 - f3;
        i = 0;
        label284:
        if ((i < localArrayList.size()) && (j > 0))
        {
          paramString = c((String)localArrayList.get(i));
          if (f1 >= this.jdField_a_of_type_Bepz.d()) {
            break label420;
          }
        }
        paramString = paramList.toString();
        if (bemo.jdField_a_of_type_JavaLangCharacter.charValue() == paramList.toString().charAt(paramList.length() - 1)) {
          paramString = paramList.substring(0, paramList.length() - 1);
        }
      }
    }
    for (paramString = paramString + (String)localObject;; paramString = paramList.toString())
    {
      this.jdField_a_of_type_Bepz.a(paramString);
      return;
      i = 0;
      break;
      label406:
      paramString = "";
      break label192;
      label413:
      paramString = "一起写";
      break label208;
      label420:
      paramString = TextUtils.ellipsize(paramString, this.jdField_a_of_type_Bepz.b(), f1, TextUtils.TruncateAt.END).toString();
      paramList.append(paramString).append(bemo.jdField_a_of_type_JavaLangCharacter);
      f1 -= localTextPaint.measureText(paramString + bemo.jdField_a_of_type_JavaLangCharacter);
      if (QLog.isColorLevel()) {
        QLog.d("UserStateController", 2, "[onPartChange] get partNickName: " + paramString);
      }
      j -= 1;
      i += 1;
      break label284;
    }
  }
  
  public void a(List<EditUserHistory> paramList)
  {
    this.jdField_a_of_type_Beob.a(paramList);
  }
  
  public void b()
  {
    Object localObject = this.jdField_a_of_type_Beoy.a();
    if ((localObject != UserState.LAST_EDIT) && (localObject != UserState.SANCTION)) {}
    long l;
    do
    {
      return;
      l = this.jdField_a_of_type_Beob.a();
      if (l > 0L) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("UserStateController", 2, "[updateSaveTime] last save time not init yet: " + l);
    return;
    localObject = a(l, (int)(a() - l), b(c(this.jdField_a_of_type_Beob.a())));
    this.jdField_a_of_type_Bepz.a((String)localObject, 1);
  }
  
  public void c()
  {
    this.jdField_a_of_type_AndroidContentContext.unregisterReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver);
    ((bemr)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(377)).b(this);
  }
  
  public void d()
  {
    this.jdField_a_of_type_Beob.a();
    this.jdField_a_of_type_Beoy.a(UserState.LAST_EDIT);
  }
  
  public void e()
  {
    if (!this.jdField_a_of_type_Boolean) {
      return;
    }
    this.jdField_a_of_type_Boolean = false;
    if ((this.jdField_a_of_type_Beoy.a() == UserState.NEW_USER_HINT) || (this.jdField_a_of_type_Beoy.a() == UserState.INACTIVATED) || (this.jdField_a_of_type_Beoy.a() == UserState.ROOM_AVAILABLE) || (this.jdField_a_of_type_Beoy.a() == UserState.LAST_EDIT))
    {
      this.jdField_a_of_type_Beoy.a(UserState.ALERT);
      return;
    }
    a("[onEditorActivated] trans from illegal state: " + this.jdField_a_of_type_Beoy.a());
  }
  
  public void f()
  {
    if (this.jdField_a_of_type_Beoy.a() == UserState.INACTIVATED)
    {
      this.jdField_a_of_type_Beoy.a(UserState.NEW_USER_HINT);
      return;
    }
    a("[onNewUserHintShow] trans from illegal state: " + this.jdField_a_of_type_Beoy.a());
  }
  
  public void onClick(View paramView)
  {
    Intent localIntent;
    if (paramView.getId() == 2131381516) {
      localIntent = new Intent(this.jdField_a_of_type_AndroidContentContext, QQBrowserActivity.class);
    }
    try
    {
      localIntent.putExtra("url", String.format("https://qun.qq.com/writetogether/history?gc=%s&padid=%s&_wv=3", new Object[] { URLEncoder.encode(this.jdField_a_of_type_Beob.d(), "utf-8"), URLEncoder.encode(this.jdField_a_of_type_Beob.a().jdField_b_of_type_JavaLangString), "utf-8" }));
      this.jdField_a_of_type_AndroidContentContext.startActivity(localIntent);
      EventCollector.getInstance().onViewClicked(paramView);
      return;
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
      for (;;)
      {
        localUnsupportedEncodingException.printStackTrace();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     benp
 * JD-Core Version:    0.7.0.1
 */