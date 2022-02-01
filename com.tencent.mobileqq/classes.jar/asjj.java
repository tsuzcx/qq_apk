import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.Emoticon;
import com.tencent.mobileqq.emoticon.SogouEmoji.3;
import com.tencent.mobileqq.emoticon.SogouEmoji.4;
import com.tencent.mobileqq.emoticonview.PicEmoticonInfo;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.os.MqqHandler;

public class asjj
{
  public static String a;
  public static String b;
  int jdField_a_of_type_Int = 0;
  antu jdField_a_of_type_Antu;
  antv jdField_a_of_type_Antv = new asjn(this);
  public asih a;
  public asiv a;
  public asjo a;
  public awyr a;
  private BaseChatPie jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie;
  public int b;
  
  static
  {
    jdField_a_of_type_JavaLangString = "taskId";
    jdField_b_of_type_JavaLangString = "exprId";
  }
  
  public asjj(BaseChatPie paramBaseChatPie)
  {
    this.jdField_a_of_type_Asiv = new asjk(this);
    if (QLog.isColorLevel()) {
      QLog.d("SogouEmoji", 2, "func SogouEmoji constructor begins");
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie = paramBaseChatPie;
    this.jdField_a_of_type_Awyr = ((awyr)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.getActivity().app.getManager(QQManagerFactory.EMOTICON_MANAGER));
    this.jdField_a_of_type_Asih = ((asih)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.getActivity().app.getManager(QQManagerFactory.CHAT_EMOTION_MANAGER));
    this.jdField_a_of_type_Antu = ((antu)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.getActivity().app.getBusinessHandler(BusinessHandlerFactory.HANDLER_EMOSM));
    this.jdField_a_of_type_Asjo = new asjo(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.getActivity());
    if (QLog.isColorLevel()) {
      QLog.d("SogouEmoji", 2, "func SogouEmoji constructor ends");
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.getActivity().app.addObserver(this.jdField_a_of_type_Antv);
  }
  
  private boolean a(String paramString)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie == null) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.getActivity().app == null))
    {
      if (QLog.isColorLevel()) {
        QLog.d("SogouEmoji", 2, "func" + paramString + " ends, maybe chatActivity is finished.");
      }
      return false;
    }
    return true;
  }
  
  public ArrayList<Emoticon> a(ArrayList<Emoticon> paramArrayList)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SogouEmoji", 2, "func getInvalidKeyEmoticon begins");
    }
    ArrayList localArrayList = new ArrayList();
    if ((paramArrayList == null) || (paramArrayList.size() == 0)) {
      return localArrayList;
    }
    paramArrayList = paramArrayList.iterator();
    while (paramArrayList.hasNext())
    {
      Emoticon localEmoticon = (Emoticon)paramArrayList.next();
      if (!localEmoticon.hasEncryptKey()) {
        localArrayList.add(localEmoticon);
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("SogouEmoji", 2, "func getInvalidKeyEmoticon ends, size:" + localArrayList.size());
    }
    return localArrayList;
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("SogouEmoji", 2, "func SogouEmoji destructor begins");
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.getActivity() != null))
    {
      QQAppInterface localQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.getActivity().app;
      if (localQQAppInterface != null) {
        localQQAppInterface.removeObserver(this.jdField_a_of_type_Antv);
      }
    }
    if (this.jdField_a_of_type_Asjo != null) {
      this.jdField_a_of_type_Asjo.a();
    }
    asig.a().b(this.jdField_a_of_type_Asiv);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie = null;
    if (QLog.isColorLevel()) {
      QLog.d("SogouEmoji", 2, "func SogouEmoji destructor ends");
    }
  }
  
  public void a(int paramInt, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SogouEmoji", 2, "func trySend begins, packId:" + paramInt + ",exprId:" + paramString);
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.getActivity() != null) && (!NetworkUtil.isNetSupport(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.getActivity().getApplicationContext())))
    {
      QQToast.a(BaseApplicationImpl.sApplication, 2131694253, 0).a();
      return;
    }
    this.jdField_a_of_type_Awyr.a(Integer.toString(paramInt), paramString, new asjl(this, paramInt, paramString));
  }
  
  void a(Emoticon paramEmoticon)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SogouEmoji", 2, "func sendEmoji begins, mCurTaskId:" + this.jdField_b_of_type_Int + ",emoticon:" + paramEmoticon);
    }
    this.jdField_a_of_type_Asjo.c();
    this.jdField_a_of_type_Asjo.a(this.jdField_b_of_type_Int);
    this.jdField_a_of_type_Asjo.b();
    if (!a("sendEmoji")) {
      return;
    }
    PicEmoticonInfo localPicEmoticonInfo = new PicEmoticonInfo(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.getActivity().app.getCurrentAccountUin());
    localPicEmoticonInfo.type = 6;
    localPicEmoticonInfo.emoticon = paramEmoticon;
    this.jdField_a_of_type_Awyr.a(paramEmoticon.epId, new asjm(this, localPicEmoticonInfo));
  }
  
  public void a(String paramString1, String paramString2, boolean paramBoolean)
  {
    paramString1 = new SogouEmoji.3(this, paramString1, paramString2, paramBoolean);
    ThreadManager.getFileThreadHandler().post(paramString1);
  }
  
  public void a(String paramString, ArrayList<Emoticon> paramArrayList)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SogouEmoji", 2, "func getPackEmojiKey begins, packId:" + paramString);
    }
    if (!a("getPackEmojiKey")) {}
    do
    {
      return;
      String str = Integer.toString(this.jdField_a_of_type_Int);
      this.jdField_a_of_type_Int += 1;
      if (asdi.a(paramString)) {
        this.jdField_a_of_type_Antu.a(Integer.parseInt(paramString), paramArrayList, str);
      }
    } while (!QLog.isColorLevel());
    QLog.d("SogouEmoji", 2, "func getPackEmojiKey ends");
  }
  
  public void a(List<String> paramList)
  {
    paramList = new SogouEmoji.4(this, paramList);
    ThreadManager.getFileThreadHandler().post(paramList);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     asjj
 * JD-Core Version:    0.7.0.1
 */