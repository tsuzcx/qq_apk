import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.Emoticon;
import com.tencent.mobileqq.emoticon.SogouEmoji.3;
import com.tencent.mobileqq.emoticon.SogouEmoji.4;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.os.MqqHandler;

public class anwx
{
  public static String a;
  public static String b;
  int jdField_a_of_type_Int = 0;
  ajvn jdField_a_of_type_Ajvn;
  ajvo jdField_a_of_type_Ajvo = new anxb(this);
  public anvx a;
  public anwl a;
  public anxc a;
  public askf a;
  private BaseChatPie jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie;
  public int b;
  
  static
  {
    jdField_a_of_type_JavaLangString = "taskId";
    jdField_b_of_type_JavaLangString = "exprId";
  }
  
  public anwx(BaseChatPie paramBaseChatPie)
  {
    this.jdField_a_of_type_Anwl = new anwy(this);
    if (QLog.isColorLevel()) {
      QLog.d("SogouEmoji", 2, "func SogouEmoji constructor begins");
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie = paramBaseChatPie;
    this.jdField_a_of_type_Askf = ((askf)this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a().app.getManager(14));
    this.jdField_a_of_type_Anvx = ((anvx)this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a().app.getManager(43));
    this.jdField_a_of_type_Ajvn = ((ajvn)this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a().app.a(12));
    this.jdField_a_of_type_Anxc = new anxc(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a());
    if (QLog.isColorLevel()) {
      QLog.d("SogouEmoji", 2, "func SogouEmoji constructor ends");
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a().app.addObserver(this.jdField_a_of_type_Ajvo);
  }
  
  private boolean a(String paramString)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie == null) || (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a().app == null))
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
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a() != null))
    {
      QQAppInterface localQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a().app;
      if (localQQAppInterface != null) {
        localQQAppInterface.removeObserver(this.jdField_a_of_type_Ajvo);
      }
    }
    if (this.jdField_a_of_type_Anxc != null) {
      this.jdField_a_of_type_Anxc.a();
    }
    anvw.a().b(this.jdField_a_of_type_Anwl);
    this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie = null;
    if (QLog.isColorLevel()) {
      QLog.d("SogouEmoji", 2, "func SogouEmoji destructor ends");
    }
  }
  
  public void a(int paramInt, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SogouEmoji", 2, "func trySend begins, packId:" + paramInt + ",exprId:" + paramString);
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a() != null) && (!bbfj.d(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a().getApplicationContext())))
    {
      bcql.a(BaseApplicationImpl.sApplication, 2131694608, 0).a();
      return;
    }
    this.jdField_a_of_type_Askf.a(Integer.toString(paramInt), paramString, new anwz(this, paramInt, paramString));
  }
  
  void a(Emoticon paramEmoticon)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SogouEmoji", 2, "func sendEmoji begins, mCurTaskId:" + this.jdField_b_of_type_Int + ",emoticon:" + paramEmoticon);
    }
    this.jdField_a_of_type_Anxc.c();
    this.jdField_a_of_type_Anxc.a(this.jdField_b_of_type_Int);
    this.jdField_a_of_type_Anxc.b();
    if (!a("sendEmoji")) {
      return;
    }
    aobp localaobp = new aobp(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a().app.getCurrentAccountUin());
    localaobp.c = 6;
    localaobp.a = paramEmoticon;
    this.jdField_a_of_type_Askf.a(paramEmoticon.epId, new anxa(this, localaobp));
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
      if (anqz.a(paramString)) {
        this.jdField_a_of_type_Ajvn.a(Integer.parseInt(paramString), paramArrayList, str);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     anwx
 * JD-Core Version:    0.7.0.1
 */