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
import com.tencent.mobileqq.app.QQManagerFactory;
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
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;
import org.jetbrains.annotations.NotNull;

public class beok
  implements View.OnClickListener, benh, beoc, beod, beoj
{
  private int jdField_a_of_type_Int;
  private BroadcastReceiver jdField_a_of_type_AndroidContentBroadcastReceiver;
  private Context jdField_a_of_type_AndroidContentContext;
  private beom jdField_a_of_type_Beom;
  private beon jdField_a_of_type_Beon;
  private beow jdField_a_of_type_Beow;
  private bepx jdField_a_of_type_Bepx;
  private berk jdField_a_of_type_Berk;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private boolean jdField_a_of_type_Boolean = true;
  
  public beok(QQAppInterface paramQQAppInterface, berk paramberk, beow parambeow, int paramInt, Context paramContext)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_Berk = paramberk;
    this.jdField_a_of_type_Beow = parambeow;
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_Bepx = new bepx(paramContext, paramInt, paramberk, parambeow);
    this.jdField_a_of_type_Bepx.a(this);
    paramQQAppInterface = paramQQAppInterface.getManager(QQManagerFactory.WRITE_TOGETHER_MANAGER);
    if ((paramQQAppInterface instanceof beng)) {
      ((beng)paramQQAppInterface).a(this);
    }
    a(paramContext);
    this.jdField_a_of_type_Berk.a().setOnClickListener(this);
  }
  
  private long a()
  {
    return System.currentTimeMillis();
  }
  
  @NotNull
  private String a(long paramLong, int paramInt, String paramString)
  {
    if (!benq.a(a(), paramLong))
    {
      if (QLog.isColorLevel()) {
        QLog.d("UserStateController", 2, "not in same year. ");
      }
      if (b()) {
        return benq.a(this.jdField_a_of_type_AndroidContentContext.getString(2131719888), paramLong);
      }
      return benq.a(this.jdField_a_of_type_AndroidContentContext.getString(2131719889), paramString, paramLong);
    }
    if (paramInt > 604800000)
    {
      if (QLog.isColorLevel()) {
        QLog.d("UserStateController", 4, "last modified before " + paramInt / 604800000 + " 7 days");
      }
      if (b()) {
        return benq.b(this.jdField_a_of_type_AndroidContentContext.getString(2131719886), paramLong);
      }
      return benq.b(this.jdField_a_of_type_AndroidContentContext.getString(2131719887), paramString, paramLong);
    }
    if (paramInt > 86400000)
    {
      paramInt /= 86400000;
      if (QLog.isColorLevel()) {
        QLog.d("UserStateController", 4, "last modified before " + paramInt + " day");
      }
      if (b()) {
        return String.format(this.jdField_a_of_type_AndroidContentContext.getString(2131719880), new Object[] { Integer.valueOf(paramInt) });
      }
      return String.format(this.jdField_a_of_type_AndroidContentContext.getString(2131719881), new Object[] { paramString, Integer.valueOf(paramInt) });
    }
    if (paramInt > 3600000)
    {
      paramInt /= 3600000;
      if (QLog.isColorLevel()) {
        QLog.d("UserStateController", 4, "last modified before " + paramInt + " hour");
      }
      if (b()) {
        return String.format(this.jdField_a_of_type_AndroidContentContext.getString(2131719882), new Object[] { Integer.valueOf(paramInt) });
      }
      return String.format(this.jdField_a_of_type_AndroidContentContext.getString(2131719883), new Object[] { paramString, Integer.valueOf(paramInt) });
    }
    if (paramInt > 60000)
    {
      paramInt /= 60000;
      if (QLog.isColorLevel()) {
        QLog.d("UserStateController", 4, "last modified before " + paramInt + " min");
      }
      if (b()) {
        return String.format(this.jdField_a_of_type_AndroidContentContext.getString(2131719884), new Object[] { Integer.valueOf(paramInt) });
      }
      return String.format(this.jdField_a_of_type_AndroidContentContext.getString(2131719885), new Object[] { paramString, Integer.valueOf(paramInt) });
    }
    if (QLog.isColorLevel()) {
      QLog.d("UserStateController", 4, "last modified in 1 min");
    }
    if (b()) {
      return this.jdField_a_of_type_AndroidContentContext.getString(2131719878);
    }
    return String.format(this.jdField_a_of_type_AndroidContentContext.getString(2131719879), new Object[] { paramString });
  }
  
  private void a(Context paramContext)
  {
    this.jdField_a_of_type_AndroidContentBroadcastReceiver = new beol(this);
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
        paramUserLeaveMsg = benq.a(paramUserLeaveMsg.userId);
        this.jdField_a_of_type_Beow.a(paramUserLeaveMsg);
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
      localObject = benq.a(((UserNewInfoMsg.Notice)localObject).userId);
      bepb localbepb = new bepb();
      localbepb.a = benq.a(((UserNewInfoMsg.Body)paramUserNewInfoMsg.body).notice.userId);
      localbepb.jdField_b_of_type_Int = benj.jdField_a_of_type_ArrayOfInt[(((UserNewInfoMsg.Body)paramUserNewInfoMsg.body).notice.colorId % benj.jdField_a_of_type_ArrayOfInt.length)];
      localbepb.jdField_b_of_type_JavaLangString = a(localbepb.a);
      if (QLog.isColorLevel()) {
        QLog.d("UserStateController", 2, "[onUserNewInfo] getNickName from ContactUtils: " + localbepb.jdField_b_of_type_JavaLangString);
      }
      this.jdField_a_of_type_Beow.a((String)localObject, l, localbepb);
      return;
      QLog.e("UserStateController", 1, "[onUserNewInfo] notice is null");
      return;
      QLog.e("UserStateController", 1, "[onUserNewInfo] body is null");
      return;
    }
  }
  
  private boolean a()
  {
    return this.jdField_a_of_type_Bepx.a() != UserState.NEW_DOC;
  }
  
  private String b(String paramString)
  {
    return TextUtils.ellipsize(paramString, this.jdField_a_of_type_Berk.b(), this.jdField_a_of_type_Berk.a(), TextUtils.TruncateAt.END).toString();
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
      if (this.jdField_a_of_type_Bepx.a() != UserState.CHARACTERS_OVERSIZE) {
        this.jdField_a_of_type_Bepx.a(UserState.CHARACTERS_OVERSIZE);
      }
    } while (this.jdField_a_of_type_Bepx.a() != UserState.CHARACTERS_OVERSIZE);
    berk localberk = this.jdField_a_of_type_Berk;
    String str = String.format(this.jdField_a_of_type_AndroidContentContext.getString(2131719890), new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt1) });
    if (this.jdField_a_of_type_Bepx.b() == UserState.NEW_DOC) {}
    for (;;)
    {
      localberk.a(str, bool);
      return;
      bool = false;
    }
  }
  
  private boolean b()
  {
    String str1 = this.jdField_a_of_type_Beow.b();
    String str2 = this.jdField_a_of_type_Beow.a();
    if ((TextUtils.isEmpty(str2)) || (TextUtils.isEmpty(str1))) {
      return true;
    }
    return str1.equals(str2);
  }
  
  private String c(String paramString)
  {
    return TextUtils.ellipsize(paramString, this.jdField_a_of_type_Berk.a(), this.jdField_a_of_type_Berk.b(), TextUtils.TruncateAt.END).toString();
  }
  
  private String d(String paramString)
  {
    return ContactUtils.getTroopMemberName(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Beow.d(), paramString);
  }
  
  protected String a(String paramString)
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
      str1 = this.jdField_a_of_type_Beow.a(paramString);
    } while (TextUtils.isEmpty(str1));
    return str1;
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("UserStateController", 4, "[onCommitStart]");
    }
    if (a())
    {
      if (this.jdField_a_of_type_Bepx.a() == UserState.ALERT) {
        this.jdField_a_of_type_Bepx.a(UserState.COMMIT_WHILE_ALERT);
      }
      if ((this.jdField_a_of_type_Bepx.a() == UserState.LAST_EDIT) || (this.jdField_a_of_type_Bepx.a() == UserState.LAST_SAVE)) {
        this.jdField_a_of_type_Bepx.a(UserState.SAVING);
      }
    }
  }
  
  public void a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("UserStateController", 4, "[onCommitComplete]");
    }
    this.jdField_a_of_type_Beow.a(a());
    this.jdField_a_of_type_Beow.b(this.jdField_a_of_type_Beow.b());
    if (a())
    {
      if (this.jdField_a_of_type_Bepx.a() == UserState.COMMIT_WHILE_ALERT) {
        this.jdField_a_of_type_Bepx.a(UserState.ACCEPT_WHILE_ALERT);
      }
      if (this.jdField_a_of_type_Bepx.a() == UserState.SAVING) {
        this.jdField_a_of_type_Bepx.a(UserState.LAST_SAVE);
      }
      if (this.jdField_a_of_type_Bepx.a() == UserState.LAST_SAVE) {
        this.jdField_a_of_type_Bepx.a(1);
      }
    }
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    beom localbeom;
    if (paramInt1 < paramInt2)
    {
      b(paramInt1, paramInt2);
      if (this.jdField_a_of_type_Beom != null)
      {
        localbeom = this.jdField_a_of_type_Beom;
        if (paramInt1 >= paramInt2) {
          break label92;
        }
      }
    }
    label92:
    for (boolean bool = true;; bool = false)
    {
      localbeom.a(bool);
      return;
      if (this.jdField_a_of_type_Bepx.a() != UserState.CHARACTERS_OVERSIZE) {
        break;
      }
      if (this.jdField_a_of_type_Bepx.b() == UserState.NEW_DOC)
      {
        this.jdField_a_of_type_Bepx.a(UserState.NEW_DOC);
        break;
      }
      this.jdField_a_of_type_Bepx.a(UserState.SAVING);
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
      b(this.jdField_a_of_type_Beow.a(), this.jdField_a_of_type_Beow.a().a.length());
      return;
    case -1: 
      this.jdField_a_of_type_Bepx.a(UserState.NET_ERR);
      return;
    case -2: 
      this.jdField_a_of_type_Bepx.a(UserState.NET_AVAIL);
      return;
    case 65020: 
      this.jdField_a_of_type_Bepx.a(UserState.GAG, paramString);
      return;
    case 65019: 
    case 65022: 
      this.jdField_a_of_type_Bepx.a(UserState.COMMIT_ERR);
      return;
    }
    this.jdField_a_of_type_Bepx.a(UserState.SANCTION);
  }
  
  public void a(beom parambeom)
  {
    this.jdField_a_of_type_Beom = parambeom;
  }
  
  public void a(beon parambeon)
  {
    this.jdField_a_of_type_Beon = parambeon;
  }
  
  public void a(BaseWriteTogetherMsg.Type paramType, boolean paramBoolean, Object paramObject)
  {
    if ((paramType == BaseWriteTogetherMsg.Type.USER_NEWINFO) && ((paramObject instanceof UserNewInfoMsg)))
    {
      paramType = (UserNewInfoMsg)paramObject;
      if (this.jdField_a_of_type_Beon != null) {
        this.jdField_a_of_type_Beon.a(paramBoolean, paramType);
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
        this.jdField_a_of_type_Bepx.a(UserState.ROOM_FULL);
        return;
      }
    } while ((!paramBoolean) || ((paramType.result != 0) && (paramType.result != 60009)) || (this.jdField_a_of_type_Bepx.a() == UserState.ROOM_AVAILABLE) || (this.jdField_a_of_type_Bepx.a() != UserState.ROOM_FULL));
    this.jdField_a_of_type_Bepx.a(UserState.ROOM_AVAILABLE);
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
      paramString = b(a(paramString));
      paramList.append(paramString).append("发起");
      if (QLog.isColorLevel()) {
        QLog.d("UserStateController", 2, "[onPartChange] get owner nick name: " + paramString);
      }
    }
    TextPaint localTextPaint;
    int i;
    label158:
    Object localObject;
    label200:
    label216:
    float f1;
    if (localArrayList.size() != 0)
    {
      if (!paramBoolean) {
        paramList.append("，");
      }
      localTextPaint = this.jdField_a_of_type_Berk.b();
      if (paramBoolean)
      {
        i = 1;
        if (j <= i) {
          break label414;
        }
        i = 1;
        localObject = new StringBuilder();
        if (i == 0) {
          break label420;
        }
        paramString = "等" + j + "人";
        localObject = ((StringBuilder)localObject).append(paramString);
        if (!paramBoolean) {
          break label427;
        }
        paramString = "正在输入";
        localObject = paramString;
        f1 = this.jdField_a_of_type_Berk.c();
        float f2 = localTextPaint.measureText(benj.jdField_a_of_type_JavaLangCharacter + paramList.toString());
        float f3 = localTextPaint.measureText((String)localObject);
        j = 3;
        f1 = f1 - f2 - f3;
        i = 0;
        label292:
        if ((i < localArrayList.size()) && (j > 0))
        {
          paramString = a((String)localArrayList.get(i));
          if (f1 >= this.jdField_a_of_type_Berk.d()) {
            break label434;
          }
        }
        paramString = paramList.toString();
        if (benj.jdField_a_of_type_JavaLangCharacter.charValue() == paramList.toString().charAt(paramList.length() - 1)) {
          paramString = paramList.substring(0, paramList.length() - 1);
        }
      }
    }
    for (paramString = paramString + (String)localObject;; paramString = paramList.toString())
    {
      this.jdField_a_of_type_Berk.a(paramString);
      return;
      i = 2;
      break;
      label414:
      i = 0;
      break label158;
      label420:
      paramString = "";
      break label200;
      label427:
      paramString = "一起写";
      break label216;
      label434:
      paramString = TextUtils.ellipsize(paramString, this.jdField_a_of_type_Berk.b(), f1, TextUtils.TruncateAt.END).toString();
      paramList.append(paramString).append(benj.jdField_a_of_type_JavaLangCharacter);
      f1 -= localTextPaint.measureText(paramString + benj.jdField_a_of_type_JavaLangCharacter);
      if (QLog.isColorLevel()) {
        QLog.d("UserStateController", 2, "[onPartChange] get partNickName: " + paramString);
      }
      j -= 1;
      i += 1;
      break label292;
    }
  }
  
  public void a(List<EditUserHistory> paramList)
  {
    this.jdField_a_of_type_Beow.a(paramList);
  }
  
  public void b()
  {
    Object localObject = this.jdField_a_of_type_Bepx.a();
    if ((localObject != UserState.LAST_EDIT) && (localObject != UserState.SANCTION)) {}
    long l;
    do
    {
      return;
      l = this.jdField_a_of_type_Beow.a();
      if (l > 0L) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("UserStateController", 2, "[updateSaveTime] last save time not init yet: " + l);
    return;
    localObject = a(l, (int)(a() - l), c(a(this.jdField_a_of_type_Beow.a())));
    this.jdField_a_of_type_Berk.a((String)localObject, 1);
  }
  
  public void c()
  {
    this.jdField_a_of_type_AndroidContentContext.unregisterReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver);
    ((benm)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.WRITE_TOGETHER_MANAGER)).b(this);
  }
  
  public void d()
  {
    this.jdField_a_of_type_Beow.a();
    this.jdField_a_of_type_Bepx.a(UserState.LAST_EDIT);
  }
  
  public void e()
  {
    if (!this.jdField_a_of_type_Boolean) {
      return;
    }
    this.jdField_a_of_type_Boolean = false;
    if ((this.jdField_a_of_type_Bepx.a() == UserState.NEW_USER_HINT) || (this.jdField_a_of_type_Bepx.a() == UserState.INACTIVATED) || (this.jdField_a_of_type_Bepx.a() == UserState.ROOM_AVAILABLE) || (this.jdField_a_of_type_Bepx.a() == UserState.LAST_EDIT))
    {
      this.jdField_a_of_type_Bepx.a(UserState.ALERT);
      return;
    }
    a("[onEditorActivated] trans from illegal state: " + this.jdField_a_of_type_Bepx.a());
  }
  
  public void f()
  {
    if (this.jdField_a_of_type_Bepx.a() == UserState.INACTIVATED)
    {
      this.jdField_a_of_type_Bepx.a(UserState.NEW_USER_HINT);
      return;
    }
    a("[onNewUserHintShow] trans from illegal state: " + this.jdField_a_of_type_Bepx.a());
  }
  
  public void onClick(View paramView)
  {
    Intent localIntent;
    if (paramView.getId() == 2131381596) {
      localIntent = new Intent(this.jdField_a_of_type_AndroidContentContext, QQBrowserActivity.class);
    }
    try
    {
      localIntent.putExtra("url", String.format("https://qun.qq.com/writetogether/history?gc=%s&padid=%s&_wv=3", new Object[] { URLEncoder.encode(this.jdField_a_of_type_Beow.d(), "utf-8"), URLEncoder.encode(this.jdField_a_of_type_Beow.a().jdField_b_of_type_JavaLangString), "utf-8" }));
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
 * Qualified Name:     beok
 * JD-Core Version:    0.7.0.1
 */