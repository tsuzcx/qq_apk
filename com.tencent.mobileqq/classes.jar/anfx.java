import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import com.tencent.mobileqq.apollo.script.SpriteBridge.1;
import com.tencent.mobileqq.apollo.script.SpriteBridge.2;
import com.tencent.mobileqq.apollo.script.SpriteBridge.3;
import com.tencent.mobileqq.apollo.script.SpriteTaskParam;
import com.tencent.mobileqq.apollo.script.SpriteUIHandler;
import com.tencent.mobileqq.apollo.utils.ApolloUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.ApolloActionData;
import com.tencent.mobileqq.data.ApolloMessage;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForApollo;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import mqq.os.MqqHandler;
import org.json.JSONArray;
import org.json.JSONObject;

public class anfx
  implements angk
{
  private anga jdField_a_of_type_Anga;
  private angb jdField_a_of_type_Angb;
  private angn jdField_a_of_type_Angn;
  private String jdField_a_of_type_JavaLangString;
  private CopyOnWriteArrayList<WeakReference<angm>> jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList;
  
  public anfx(anga paramanga, angn paramangn, angb paramangb)
  {
    this.jdField_a_of_type_Anga = paramanga;
    this.jdField_a_of_type_Angn = paramangn;
    this.jdField_a_of_type_Angb = paramangb;
    this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList = new CopyOnWriteArrayList();
  }
  
  private String a()
  {
    SpriteTaskParam localSpriteTaskParam = new SpriteTaskParam();
    localSpriteTaskParam.jdField_a_of_type_Int = 0;
    localSpriteTaskParam.f = 4;
    localSpriteTaskParam.k = 2;
    localSpriteTaskParam.g = 5;
    localSpriteTaskParam.jdField_a_of_type_Long = 1000000L;
    return this.jdField_a_of_type_Angb.a(localSpriteTaskParam);
  }
  
  private String a(SpriteTaskParam paramSpriteTaskParam)
  {
    Object localObject;
    if (paramSpriteTaskParam == null) {
      localObject = a();
    }
    String str;
    do
    {
      return localObject;
      if (!a(paramSpriteTaskParam.jdField_c_of_type_Int, paramSpriteTaskParam.f))
      {
        QLog.w("cmshow_scripted_SpriteBridge", 1, "[playAction], fail to load script.");
        paramSpriteTaskParam.jdField_b_of_type_Int = 4;
        return a();
      }
      str = this.jdField_a_of_type_Angb.a(paramSpriteTaskParam);
      localObject = str;
    } while (!TextUtils.isEmpty(str));
    paramSpriteTaskParam.jdField_b_of_type_Int = 4;
    return a();
  }
  
  private boolean a(int paramInt)
  {
    boolean bool2;
    if ((this.jdField_a_of_type_Anga == null) || (this.jdField_a_of_type_Anga.b == null))
    {
      bool2 = false;
      return bool2;
    }
    Object localObject1 = (QQAppInterface)this.jdField_a_of_type_Anga.b.get();
    if (localObject1 != null)
    {
      Object localObject2 = ((QQAppInterface)localObject1).getApp().getSharedPreferences("apollo_action_random", 0);
      localObject1 = String.valueOf(paramInt);
      if (((SharedPreferences)localObject2).getInt((String)localObject1, -1) > 0) {}
      for (boolean bool1 = true;; bool1 = false)
      {
        bool2 = bool1;
        if (bool1) {
          break;
        }
        localObject2 = ((SharedPreferences)localObject2).edit();
        ((SharedPreferences.Editor)localObject2).putInt((String)localObject1, paramInt);
        ((SharedPreferences.Editor)localObject2).commit();
        return bool1;
      }
    }
    return false;
  }
  
  private boolean a(int paramInt1, int paramInt2)
  {
    if ((this.jdField_a_of_type_Anga == null) || (this.jdField_a_of_type_Anga.a() == null)) {
      return false;
    }
    return ((angf)this.jdField_a_of_type_Anga.a().getManager(249)).a().a(paramInt1, paramInt2) != null;
  }
  
  private void c()
  {
    ThreadManager.getUIHandler().post(new SpriteBridge.3(this));
  }
  
  public void a()
  {
    this.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_Angb.a();
  }
  
  public void a(int paramInt)
  {
    if ((this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList == null) || (this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.size() == 0)) {}
    for (;;)
    {
      return;
      Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.iterator();
      while (localIterator.hasNext())
      {
        angm localangm = (angm)((WeakReference)localIterator.next()).get();
        if (localangm != null) {
          localangm.a(paramInt);
        }
      }
    }
  }
  
  public void a(int paramInt, MessageForApollo paramMessageForApollo)
  {
    int i = 0;
    if (QLog.isColorLevel()) {
      QLog.d("cmshow_scripted_SpriteBridge", 2, new Object[] { "[buildSpriteTask], from:", Integer.valueOf(paramInt) });
    }
    if ((paramMessageForApollo == null) || (this.jdField_a_of_type_Anga == null) || (this.jdField_a_of_type_Angn == null)) {
      break label48;
    }
    label48:
    while (!angi.b(this.jdField_a_of_type_Anga.a(), paramMessageForApollo.istroop, paramMessageForApollo.frienduin)) {
      return;
    }
    SpriteTaskParam localSpriteTaskParam = new SpriteTaskParam();
    localSpriteTaskParam.f = ApolloUtil.a(this.jdField_a_of_type_Anga, paramMessageForApollo);
    localSpriteTaskParam.jdField_c_of_type_Int = ApolloUtil.b(this.jdField_a_of_type_Anga, paramMessageForApollo);
    localSpriteTaskParam.h = paramMessageForApollo.istroop;
    localSpriteTaskParam.g = paramInt;
    localSpriteTaskParam.jdField_a_of_type_Boolean = paramMessageForApollo.isSend();
    localSpriteTaskParam.jdField_a_of_type_Long = paramMessageForApollo.uniseq;
    localSpriteTaskParam.i = paramMessageForApollo.audioId;
    localSpriteTaskParam.jdField_a_of_type_Float = paramMessageForApollo.audioStartTime;
    if (paramMessageForApollo.isDoubleAction()) {
      i = 1;
    }
    localSpriteTaskParam.e = i;
    localSpriteTaskParam.jdField_c_of_type_JavaLangString = paramMessageForApollo.inputText;
    localSpriteTaskParam.jdField_b_of_type_Boolean = paramMessageForApollo.isBarrageMode();
    localSpriteTaskParam.jdField_d_of_type_JavaLangString = paramMessageForApollo.extendJson;
    localSpriteTaskParam.l = paramMessageForApollo.mSendSrc;
    if (localSpriteTaskParam.h == 0) {
      if (paramMessageForApollo.isSend())
      {
        localSpriteTaskParam.jdField_a_of_type_JavaLangString = paramMessageForApollo.selfuin;
        localSpriteTaskParam.jdField_b_of_type_JavaLangString = paramMessageForApollo.frienduin;
      }
    }
    for (;;)
    {
      a(localSpriteTaskParam);
      if (paramInt != 2) {
        break;
      }
      angi.a(this.jdField_a_of_type_Anga.a(), localSpriteTaskParam);
      return;
      localSpriteTaskParam.jdField_a_of_type_JavaLangString = paramMessageForApollo.frienduin;
      localSpriteTaskParam.jdField_b_of_type_JavaLangString = paramMessageForApollo.selfuin;
      continue;
      if ((localSpriteTaskParam.h == 1) || (localSpriteTaskParam.h == 3000))
      {
        localSpriteTaskParam.jdField_b_of_type_JavaLangString = Long.toString(paramMessageForApollo.mApolloMessage.peer_uin);
        localSpriteTaskParam.jdField_a_of_type_JavaLangString = paramMessageForApollo.senderuin;
      }
    }
  }
  
  public void a(anga paramanga)
  {
    if (QLog.isColorLevel()) {
      QLog.d("cmshow_scripted_SpriteBridge", 2, "[initSprite]");
    }
    int i = angi.b(0);
    if ((this.jdField_a_of_type_Angb == null) || (paramanga == null) || (!paramanga.c())) {
      anmq.a(i, 300, 160, new Object[] { "glview is not ready" });
    }
    String str;
    anfr localanfr;
    do
    {
      do
      {
        return;
      } while (!a(0, -1));
      if (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString))
      {
        str = this.jdField_a_of_type_Angb.a();
        QLog.d("CmShowStatUtil", 1, "get spriteJs");
      }
      while (TextUtils.isEmpty(str))
      {
        anmq.a(i, 300, 301, new Object[] { "spriteJs is empty" });
        return;
        str = this.jdField_a_of_type_JavaLangString;
        QLog.d("CmShowStatUtil", 1, "spriteJs from cache");
        this.jdField_a_of_type_JavaLangString = null;
      }
      localanfr = angi.a(paramanga.a());
    } while (localanfr == null);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("initSprite('").append(str).append("');");
    anmq.a(i, 350);
    QLog.d("cmshow_scripted_SpriteBridge", 1, "TraceReport CmShowStatUtil commitJS:(initSprite )");
    localanfr.a(localStringBuilder.toString());
    ThreadManager.executeOnSubThread(new SpriteBridge.2(this, localanfr, paramanga));
  }
  
  public void a(angm paramangm)
  {
    if (this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList == null) {
      return;
    }
    this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.add(new WeakReference(paramangm));
  }
  
  public void a(SpriteTaskParam paramSpriteTaskParam)
  {
    if (paramSpriteTaskParam == null) {
      return;
    }
    ThreadManager.excute(new SpriteBridge.1(this, paramSpriteTaskParam), 192, null, true);
  }
  
  public void a(ChatMessage paramChatMessage, int paramInt)
  {
    if ((paramChatMessage == null) || (this.jdField_a_of_type_Anga == null) || (this.jdField_a_of_type_Angn == null)) {}
    while (!angi.b(this.jdField_a_of_type_Anga.a(), paramChatMessage.istroop, paramChatMessage.frienduin)) {
      return;
    }
    SpriteTaskParam localSpriteTaskParam = new SpriteTaskParam();
    localSpriteTaskParam.f = paramInt;
    ApolloActionData localApolloActionData = angi.a(this.jdField_a_of_type_Anga.a(), paramInt);
    if (localApolloActionData != null)
    {
      localSpriteTaskParam.jdField_c_of_type_Int = localApolloActionData.actionType;
      localSpriteTaskParam.e = localApolloActionData.personNum;
    }
    localSpriteTaskParam.h = paramChatMessage.istroop;
    if (paramChatMessage.isSend())
    {
      localSpriteTaskParam.g = 0;
      localSpriteTaskParam.jdField_a_of_type_Boolean = paramChatMessage.isSend();
      localSpriteTaskParam.jdField_a_of_type_Long = paramChatMessage.uniseq;
      if (localSpriteTaskParam.h != 0) {
        break label188;
      }
      if (!paramChatMessage.isSend()) {
        break label169;
      }
      localSpriteTaskParam.jdField_a_of_type_JavaLangString = paramChatMessage.selfuin;
      localSpriteTaskParam.jdField_b_of_type_JavaLangString = paramChatMessage.frienduin;
    }
    for (;;)
    {
      a(localSpriteTaskParam);
      return;
      localSpriteTaskParam.g = 1;
      break;
      label169:
      localSpriteTaskParam.jdField_a_of_type_JavaLangString = paramChatMessage.frienduin;
      localSpriteTaskParam.jdField_b_of_type_JavaLangString = paramChatMessage.selfuin;
      continue;
      label188:
      if ((localSpriteTaskParam.h == 1) || (localSpriteTaskParam.h == 3000)) {
        localSpriteTaskParam.jdField_a_of_type_JavaLangString = paramChatMessage.senderuin;
      }
    }
  }
  
  public void a(ChatMessage paramChatMessage, ArrayList<Integer> paramArrayList1, ArrayList<Integer> paramArrayList2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("cmshow_scripted_SpriteBridge", 2, "[buildSpriteTask]");
    }
    if ((paramChatMessage == null) || (this.jdField_a_of_type_Anga == null) || (this.jdField_a_of_type_Angn == null) || (paramArrayList1 == null) || (paramArrayList1.size() == 0)) {}
    while (!angi.b(this.jdField_a_of_type_Anga.a(), paramChatMessage.istroop, paramChatMessage.frienduin)) {
      return;
    }
    SpriteTaskParam localSpriteTaskParam = new SpriteTaskParam();
    localSpriteTaskParam.f = ((Integer)paramArrayList1.get(0)).intValue();
    localSpriteTaskParam.jdField_d_of_type_Int = 1;
    localSpriteTaskParam.jdField_a_of_type_JavaUtilArrayList = paramArrayList1;
    localSpriteTaskParam.jdField_b_of_type_JavaUtilArrayList = paramArrayList2;
    localSpriteTaskParam.jdField_c_of_type_Int = 1;
    localSpriteTaskParam.h = paramChatMessage.istroop;
    if (paramChatMessage.isSend())
    {
      localSpriteTaskParam.g = 0;
      localSpriteTaskParam.jdField_a_of_type_Boolean = paramChatMessage.isSend();
      localSpriteTaskParam.jdField_a_of_type_Long = paramChatMessage.uniseq;
      if (localSpriteTaskParam.h != 0) {
        break label225;
      }
      if (!paramChatMessage.isSend()) {
        break label204;
      }
      localSpriteTaskParam.jdField_a_of_type_JavaLangString = paramChatMessage.selfuin;
      localSpriteTaskParam.jdField_b_of_type_JavaLangString = paramChatMessage.frienduin;
    }
    for (;;)
    {
      a(localSpriteTaskParam);
      return;
      localSpriteTaskParam.g = 1;
      break;
      label204:
      localSpriteTaskParam.jdField_a_of_type_JavaLangString = paramChatMessage.frienduin;
      localSpriteTaskParam.jdField_b_of_type_JavaLangString = paramChatMessage.selfuin;
      continue;
      label225:
      if ((localSpriteTaskParam.h == 1) || (localSpriteTaskParam.h == 3000)) {
        localSpriteTaskParam.jdField_a_of_type_JavaLangString = paramChatMessage.senderuin;
      }
    }
  }
  
  public void a(MessageForApollo paramMessageForApollo)
  {
    if (QLog.isColorLevel()) {
      QLog.d("cmshow_scripted_SpriteBridge", 2, new Object[] { "[sendMsg], msg:", paramMessageForApollo });
    }
    try
    {
      if (!a(paramMessageForApollo.actionType, paramMessageForApollo.mApolloMessage.id))
      {
        QLog.w("cmshow_scripted_SpriteBridge", 1, "[sendMsg], fail to load script, actionType:" + paramMessageForApollo.actionType);
        return;
      }
      if ((!this.jdField_a_of_type_Anga.h()) && (this.jdField_a_of_type_Anga.g()))
      {
        localObject1 = angi.a(this.jdField_a_of_type_Anga.a()).a();
        if (localObject1 != null) {
          ((SpriteUIHandler)localObject1).a(false, "none_apollo_play_action");
        }
      }
      Object localObject1 = new JSONObject();
      Object localObject2 = new JSONObject();
      ((JSONObject)localObject2).put("id", paramMessageForApollo.mApolloMessage.id);
      if (paramMessageForApollo.mApolloMessage.name != null) {
        ((JSONObject)localObject2).put("name", angi.a(bhkv.encodeToString(paramMessageForApollo.mApolloMessage.name, 0)));
      }
      if (paramMessageForApollo.mApolloMessage.text != null) {
        ((JSONObject)localObject2).put("atText", angi.a(bhkv.encodeToString(paramMessageForApollo.mApolloMessage.text, 0)));
      }
      ((JSONObject)localObject2).put("peerUin", paramMessageForApollo.mApolloMessage.peer_uin);
      if (!TextUtils.isEmpty(paramMessageForApollo.mApolloMessage.extStr)) {
        ((JSONObject)localObject2).put("extraStr", new JSONObject(paramMessageForApollo.mApolloMessage.extStr));
      }
      ApolloMessage localApolloMessage = paramMessageForApollo.mApolloMessage;
      localApolloMessage.flag |= 0x200;
      ((JSONObject)localObject2).put("model", ApolloActionData.getModelString(paramMessageForApollo.mApolloMessage.id));
      ((JSONObject)localObject2).put("flag", paramMessageForApollo.mApolloMessage.flag);
      ((JSONObject)localObject2).put("senderTS", paramMessageForApollo.mApolloMessage.sender_ts);
      ((JSONObject)localObject2).put("peerTS", paramMessageForApollo.mApolloMessage.peer_ts);
      ((JSONObject)localObject2).put("senderStatus", paramMessageForApollo.mApolloMessage.sender_status);
      ((JSONObject)localObject2).put("peerStatus", paramMessageForApollo.mApolloMessage.peer_status);
      if (8 == paramMessageForApollo.actionType)
      {
        ((JSONObject)localObject2).put("actionRootPath", "" + paramMessageForApollo.mApolloMessage.id);
        ((JSONObject)localObject2).put("isSend", a(paramMessageForApollo.mApolloMessage.id));
      }
      ((JSONObject)localObject1).put("type", paramMessageForApollo.actionType);
      ((JSONObject)localObject1).put("basicMsg", localObject2);
      paramMessageForApollo = angi.a(this.jdField_a_of_type_Anga.a());
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("sendMsg").append("('").append(((JSONObject)localObject1).toString()).append("');");
      if (paramMessageForApollo != null)
      {
        paramMessageForApollo.a(((StringBuilder)localObject2).toString());
        return;
      }
    }
    catch (Throwable paramMessageForApollo)
    {
      QLog.e("cmshow_scripted_SpriteBridge", 1, paramMessageForApollo, new Object[0]);
    }
  }
  
  public void a(List<SpriteTaskParam> paramList)
  {
    if ((paramList == null) || (paramList.size() == 0) || (this.jdField_a_of_type_Angb == null) || (this.jdField_a_of_type_Anga == null) || (!this.jdField_a_of_type_Anga.c())) {}
    do
    {
      return;
      localObject = ((angf)this.jdField_a_of_type_Anga.a().getManager(249)).a();
    } while (localObject == null);
    Object localObject = ((ange)localObject).a(0);
    if (localObject == null)
    {
      QLog.w("cmshow_scripted_SpriteBridge", 1, "actionScript == null.");
      return;
    }
    JSONArray localJSONArray = new JSONArray();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      SpriteTaskParam localSpriteTaskParam = (SpriteTaskParam)paramList.next();
      try
      {
        localJSONArray.put(new JSONObject(a(localSpriteTaskParam)));
        ((anfs)localObject).a(localSpriteTaskParam.jdField_a_of_type_JavaLangString, false);
      }
      catch (Exception localException)
      {
        QLog.e("cmshow_scripted_SpriteBridge", 1, "[playAction] e:", localException);
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("cmshow_scripted_SpriteBridge", 2, "[playAction], ready to play");
    }
    paramList = new StringBuilder();
    paramList.append("playShowAction('").append(localJSONArray.toString()).append("');");
    ((anfs)localObject).a(paramList.toString());
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList != null) {
      this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.clear();
    }
  }
  
  public void b(SpriteTaskParam paramSpriteTaskParam)
  {
    boolean bool = true;
    if ((paramSpriteTaskParam == null) || (this.jdField_a_of_type_Angb == null) || (this.jdField_a_of_type_Anga == null) || (!this.jdField_a_of_type_Anga.c())) {}
    Object localObject1;
    do
    {
      return;
      if ((paramSpriteTaskParam.jdField_b_of_type_JavaUtilArrayList != null) && (paramSpriteTaskParam.jdField_b_of_type_JavaUtilArrayList.size() > 0) && (!this.jdField_a_of_type_Anga.e()))
      {
        QLog.w("cmshow_scripted_SpriteBridge", 2, "[playAction], BackgroundSurface is not ready and add now");
        c();
        return;
      }
      this.jdField_a_of_type_Angb.a(paramSpriteTaskParam);
      if (!a(paramSpriteTaskParam.jdField_c_of_type_Int, paramSpriteTaskParam.f))
      {
        QLog.w("cmshow_scripted_SpriteBridge", 1, "[playAction], fail to load script.");
        paramSpriteTaskParam.jdField_b_of_type_Int = 4;
        return;
      }
      localObject2 = this.jdField_a_of_type_Angb.a(paramSpriteTaskParam);
      if (TextUtils.isEmpty((CharSequence)localObject2))
      {
        paramSpriteTaskParam.jdField_b_of_type_Int = 4;
        return;
      }
      localObject1 = (angf)this.jdField_a_of_type_Anga.a().getManager(249);
      localObject3 = ((angf)localObject1).a();
    } while (localObject3 == null);
    Object localObject3 = ((ange)localObject3).a(paramSpriteTaskParam.jdField_c_of_type_Int);
    if (localObject3 == null)
    {
      QLog.w("cmshow_scripted_SpriteBridge", 1, "actionScript == null.");
      paramSpriteTaskParam.jdField_b_of_type_Int = 4;
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("cmshow_scripted_SpriteBridge", 2, new Object[] { "[playAction], ready to play, actionId:", Integer.valueOf(paramSpriteTaskParam.f) });
    }
    paramSpriteTaskParam.jdField_b_of_type_Int = 2;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("playAction('").append((String)localObject2).append("');");
    ((anfs)localObject3).a(localStringBuilder.toString());
    ((anfs)localObject3).a(paramSpriteTaskParam.jdField_a_of_type_JavaLangString, false);
    ((anfs)localObject3).a(paramSpriteTaskParam.jdField_b_of_type_JavaLangString, false);
    Object localObject2 = this.jdField_a_of_type_Anga.a();
    if (!TextUtils.isEmpty(paramSpriteTaskParam.jdField_c_of_type_JavaLangString)) {}
    for (;;)
    {
      anlk.a((QQAppInterface)localObject2, paramSpriteTaskParam, bool, paramSpriteTaskParam.jdField_b_of_type_Boolean);
      localObject1 = ((angf)localObject1).a();
      if ((localObject1 == null) || (angi.a(this.jdField_a_of_type_Anga.a()))) {
        break;
      }
      if ((paramSpriteTaskParam.jdField_b_of_type_JavaUtilArrayList == null) || (paramSpriteTaskParam.jdField_b_of_type_JavaUtilArrayList.size() <= 0)) {
        break label372;
      }
      ((anfw)localObject1).a(paramSpriteTaskParam.jdField_b_of_type_JavaUtilArrayList);
      return;
      bool = false;
    }
    label372:
    ((anfw)localObject1).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     anfx
 * JD-Core Version:    0.7.0.1
 */