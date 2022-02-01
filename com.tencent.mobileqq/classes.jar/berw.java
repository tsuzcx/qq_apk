import android.content.Context;
import android.support.annotation.Nullable;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.ArkAppMessage;
import com.tencent.mobileqq.data.MessageForArkApp;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import java.util.Observable;
import java.util.Observer;
import org.json.JSONObject;

public class berw
  extends beqz
  implements Observer
{
  private long jdField_a_of_type_Long;
  @Nullable
  private beaw jdField_a_of_type_Beaw;
  private beba jdField_a_of_type_Beba;
  @Nullable
  private beri jdField_a_of_type_Beri;
  private Object jdField_a_of_type_JavaLangObject;
  
  berw(QQAppInterface paramQQAppInterface, Context paramContext, beri paramberi, SessionInfo paramSessionInfo)
  {
    super(paramQQAppInterface, paramContext, paramSessionInfo);
    this.jdField_a_of_type_Int = 102;
    this.jdField_a_of_type_Beri = paramberi;
  }
  
  public int a(int paramInt)
  {
    return 2130850663;
  }
  
  @Nullable
  public bera a(int paramInt1, List<Long> paramList, long paramLong1, Object paramObject, long paramLong2, long paramLong3, int paramInt2)
  {
    this.jdField_a_of_type_Long = paramLong1;
    this.jdField_a_of_type_JavaLangObject = paramObject;
    paramList = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().queryMsgItemByUniseq(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curFriendUin, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curType, paramLong1);
    if ((paramList != null) && (a(paramList, paramLong2, paramLong3))) {
      return new bera(true, this.jdField_a_of_type_AndroidContentContext.getString(2131697097), bdyo.a(paramInt1, paramLong1, paramInt2), paramList.senderuin);
    }
    return null;
  }
  
  public void a()
  {
    super.a();
    this.jdField_a_of_type_Beba = null;
    avtd localavtd = (avtd)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(37);
    long l = bfwt.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curFriendUin);
    if (l == -1L) {}
    do
    {
      return;
      this.jdField_a_of_type_Beaw = localavtd.a(Long.valueOf(l), true);
      if (this.jdField_a_of_type_Beaw != null) {
        this.jdField_a_of_type_Beaw.addObserver(this);
      }
    } while (!QLog.isColorLevel());
    QLog.d(this.jdField_a_of_type_JavaLangString, 2, "onInit");
  }
  
  public void a(int paramInt, TextView paramTextView1, TextView paramTextView2, ImageView paramImageView, String paramString)
  {
    paramTextView1.setText(paramString);
    paramTextView1.setVisibility(0);
    paramTextView2.setVisibility(8);
  }
  
  public void a(int paramInt, Object paramObject, String paramString)
  {
    paramObject = (TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(52);
    String str;
    long l;
    if (paramObject != null)
    {
      paramObject = paramObject.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curFriendUin);
      if (paramObject != null)
      {
        boolean bool = paramString.equals(this.jdField_a_of_type_AndroidContentContext.getString(2131697109));
        paramString = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
        str = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curFriendUin;
        l = paramObject.dwGroupClassExt;
        if (!bool) {
          break label104;
        }
      }
    }
    label104:
    for (paramObject = "2";; paramObject = "1")
    {
      bcef.b(paramString, "dc00898", "", "", "", "0X800AACB", 0, 1, 0, str, String.valueOf(l), paramObject, "");
      return;
    }
  }
  
  public void b()
  {
    super.b();
    this.jdField_a_of_type_Beba = null;
    if (this.jdField_a_of_type_Beaw != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d(this.jdField_a_of_type_JavaLangString, 2, "onUnInit");
      }
      this.jdField_a_of_type_Beaw.deleteObserver(this);
      this.jdField_a_of_type_Beaw = null;
    }
    this.jdField_a_of_type_Beri = null;
  }
  
  public void b(int paramInt, Object paramObject, String paramString)
  {
    paramObject = (TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(52);
    String str;
    long l;
    if (paramObject != null)
    {
      paramObject = paramObject.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curFriendUin);
      if (paramObject != null)
      {
        boolean bool = paramString.equals(this.jdField_a_of_type_AndroidContentContext.getString(2131697109));
        paramString = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
        str = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curFriendUin;
        l = paramObject.dwGroupClassExt;
        if (!bool) {
          break label104;
        }
      }
    }
    label104:
    for (paramObject = "2";; paramObject = "1")
    {
      bcef.b(paramString, "dc00898", "", "", "", "0X800AACC", 0, 1, 0, str, String.valueOf(l), paramObject, "");
      return;
    }
  }
  
  void c()
  {
    if (this.jdField_a_of_type_Beri == null) {
      if (QLog.isColorLevel()) {
        QLog.d(this.jdField_a_of_type_JavaLangString, 2, "mTroopAioMsgNavigateBar = null");
      }
    }
    boolean bool3;
    do
    {
      return;
      bool3 = this.jdField_a_of_type_Beri.d();
      if (QLog.isColorLevel()) {
        QLog.d(this.jdField_a_of_type_JavaLangString, 2, "showTroopNotifyBar troopNotifyData = " + this.jdField_a_of_type_Beba + ",  mFIsShow = " + bool3);
      }
    } while (this.jdField_a_of_type_Beba == null);
    if (this.jdField_a_of_type_Beri.a())
    {
      this.jdField_a_of_type_Beba = null;
      return;
    }
    bool2 = false;
    str2 = "";
    Object localObject1 = str2;
    bool1 = bool2;
    Object localObject2;
    if (bool3)
    {
      localObject1 = str2;
      bool1 = bool2;
      if (!this.jdField_a_of_type_Beba.b)
      {
        localObject1 = str2;
        bool1 = bool2;
        if ((this.jdField_a_of_type_JavaLangObject instanceof MessageForArkApp))
        {
          localObject1 = str2;
          bool1 = bool2;
          if (!this.jdField_a_of_type_Beba.d)
          {
            localObject2 = (MessageForArkApp)this.jdField_a_of_type_JavaLangObject;
            localObject1 = str2;
            bool1 = bool2;
            if (((MessageForArkApp)localObject2).ark_app_message != null)
            {
              localObject1 = str2;
              bool1 = bool2;
              if (!"com.tencent.mannounce".equals(((MessageForArkApp)localObject2).ark_app_message.appName)) {}
            }
          }
        }
      }
    }
    for (;;)
    {
      try
      {
        if (QLog.isColorLevel())
        {
          QLog.d(this.jdField_a_of_type_JavaLangString, 2, "showTroopNotifyBar ark.ark_app_message.metaList:" + ((MessageForArkApp)localObject2).ark_app_message.metaList);
          QLog.d(this.jdField_a_of_type_JavaLangString, 2, "showTroopNotifyBar mTroopNotifyData confirmRequired:" + this.jdField_a_of_type_Beba.c + " fid:" + this.jdField_a_of_type_Beba.jdField_a_of_type_JavaLangString + " isShowTipWindow:" + this.jdField_a_of_type_Beba.b);
        }
        localObject1 = new JSONObject(((MessageForArkApp)localObject2).ark_app_message.metaList).optJSONObject("mannounce");
        localObject2 = this.jdField_a_of_type_Beri.a();
        if ((localObject1 == null) || (localObject2 == null) || (!((JSONObject)localObject1).optString("fid").equals(this.jdField_a_of_type_Beba.jdField_a_of_type_JavaLangString))) {
          continue;
        }
        long l = ((MessageRecord)localObject2).shmsgseq;
        localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().queryMsgItemByUniseq(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curFriendUin, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curType, this.jdField_a_of_type_Long);
        if ((localObject1 == null) || (!a((MessageRecord)localObject1, l, this.jdField_a_of_type_Beri.a()))) {
          continue;
        }
        if (!this.jdField_a_of_type_Beba.c) {
          continue;
        }
        localObject1 = this.jdField_a_of_type_AndroidContentContext.getString(2131697109);
        bool1 = true;
      }
      catch (Exception localException)
      {
        QLog.e(this.jdField_a_of_type_JavaLangString, 1, "[showTroopNotifyBar] ", localException);
        String str1 = str2;
        bool1 = bool2;
        continue;
        str1 = "";
        bool1 = false;
        continue;
      }
      this.jdField_a_of_type_Beri.a(new bera(bool1, (String)localObject1, null, ""));
      this.jdField_a_of_type_Beba = null;
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d(this.jdField_a_of_type_JavaLangString, 2, "showTroopNotifyBar mFIsShow:" + bool1);
      return;
      localObject1 = this.jdField_a_of_type_AndroidContentContext.getString(2131697097);
    }
  }
  
  public void update(Observable paramObservable, Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_a_of_type_JavaLangString, 2, "troopNotify update");
    }
    if (!(paramObject instanceof Integer)) {}
    do
    {
      do
      {
        return;
        paramObservable = (Integer)paramObject;
        if (QLog.isColorLevel()) {
          QLog.d(this.jdField_a_of_type_JavaLangString, 2, "update. notifyType = " + paramObservable);
        }
      } while ((paramObservable.intValue() != 1007) && (paramObservable.intValue() != 1011));
      if ((this.jdField_a_of_type_Beaw != null) && (this.jdField_a_of_type_Beaw.b != null)) {
        try
        {
          this.jdField_a_of_type_Beba = beba.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curFriendUin, this.jdField_a_of_type_Beaw.b);
          c();
          return;
        }
        finally {}
      }
    } while (!QLog.isColorLevel());
    QLog.d(this.jdField_a_of_type_JavaLangString, 2, "update. mNewNorNotice = null!");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     berw
 * JD-Core Version:    0.7.0.1
 */