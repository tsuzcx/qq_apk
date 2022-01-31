import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.troop.homework.recite.data.ArticleInfo;
import com.tencent.mobileqq.troop.homework.recite.data.ParagraphInfo;
import com.tencent.mobileqq.troop.homework.recite.data.WordInfo;
import com.tencent.mobileqq.troop.homework.recite.ui.PinyinTextView;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;

public class baan
{
  double jdField_a_of_type_Double = -1.0D;
  protected int a;
  protected Handler a;
  protected HandlerThread a;
  protected baap a;
  protected baaq a;
  QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  TroopManager jdField_a_of_type_ComTencentMobileqqAppTroopManager;
  protected ArticleInfo a;
  WordInfo jdField_a_of_type_ComTencentMobileqqTroopHomeworkReciteDataWordInfo = null;
  String jdField_a_of_type_JavaLangString;
  protected ArrayList<WordInfo> a;
  protected List<String> a;
  protected boolean a;
  protected int b;
  boolean b;
  protected int c;
  int d = 0;
  int e = 0;
  int f = -1;
  int g = 0;
  int h = 0;
  
  public baan(ArticleInfo paramArticleInfo, baaq parambaaq, QQAppInterface paramQQAppInterface, String paramString)
  {
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_b_of_type_Boolean = false;
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList(2);
    this.jdField_a_of_type_AndroidOsHandler = new baao(this, Looper.getMainLooper());
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkReciteDataArticleInfo = paramArticleInfo;
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_ComTencentMobileqqAppTroopManager = ((TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(52));
    int i = 0;
    while (i < this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkReciteDataArticleInfo.paragraphs.size())
    {
      ((ParagraphInfo)this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkReciteDataArticleInfo.paragraphs.get(i)).resetWordsReciteStatus();
      i += 1;
    }
    this.jdField_a_of_type_Baaq = parambaaq;
    this.jdField_a_of_type_AndroidOsHandlerThread = new HandlerThread("ReciteDetectHandlerThread");
    this.jdField_a_of_type_AndroidOsHandlerThread.start();
    this.jdField_a_of_type_Baap = new baap(this, this.jdField_a_of_type_AndroidOsHandlerThread.getLooper());
    this.jdField_a_of_type_Boolean = false;
  }
  
  protected WordInfo a()
  {
    for (;;)
    {
      try
      {
        if (QLog.isColorLevel()) {
          QLog.d("ReciteDetect.ReciteDetectManager", 2, "getNextWord detectingParagraphPos = " + this.e + " detectingWordInParagaphPos" + this.f + " lastParagraphDetectEnd" + this.jdField_b_of_type_Boolean);
        }
        if (this.jdField_b_of_type_Boolean)
        {
          this.e += 1;
          this.f = 0;
          this.jdField_b_of_type_Boolean = false;
          if (this.e < this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkReciteDataArticleInfo.paragraphs.size())
          {
            Object localObject1 = ((ParagraphInfo)this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkReciteDataArticleInfo.paragraphs.get(this.e)).generateOrGetWordInfoList(this.e);
            if (this.f < ((List)localObject1).size())
            {
              WordInfo localWordInfo = (WordInfo)((List)localObject1).get(this.f);
              localWordInfo.paragraphPos = this.e;
              if (QLog.isColorLevel()) {
                QLog.d("ReciteDetect.ReciteDetectManager", 2, String.format("正在检测的文字是：%s", new Object[] { localWordInfo.toString() }));
              }
              if (this.f == ((List)localObject1).size() - 1) {
                this.jdField_b_of_type_Boolean = true;
              }
              localObject1 = localWordInfo;
              if (!PinyinTextView.a(localWordInfo.text))
              {
                this.jdField_a_of_type_Int += 1;
                localObject1 = localWordInfo;
              }
              return localObject1;
            }
          }
        }
        else
        {
          this.f += 1;
          continue;
        }
        Object localObject3 = null;
      }
      finally {}
    }
  }
  
  protected void a()
  {
    this.jdField_a_of_type_JavaUtilList.clear();
    this.jdField_b_of_type_Int = 0;
    this.jdField_a_of_type_Boolean = true;
    this.c = 0;
    this.jdField_a_of_type_Double = 0.0D;
    this.g = 0;
    this.h = 0;
  }
  
  public void a(double paramDouble, String[] paramArrayOfString)
  {
    if ((paramArrayOfString == null) || (paramArrayOfString.length == 0) || (this.jdField_a_of_type_Baaq == null) || (this.jdField_a_of_type_Boolean)) {}
    while (this.jdField_a_of_type_Double > paramDouble) {
      return;
    }
    Message localMessage = this.jdField_a_of_type_Baap.obtainMessage(2);
    Bundle localBundle = new Bundle();
    localBundle.putDouble("startTime", paramDouble);
    localBundle.putStringArray("pinyins", paramArrayOfString);
    localMessage.setData(localBundle);
    localMessage.sendToTarget();
  }
  
  protected void a(int paramInt)
  {
    int i;
    label197:
    do
    {
      for (;;)
      {
        try
        {
          if (QLog.isColorLevel()) {
            QLog.d("ReciteDetect.ReciteDetectManager", 2, "doDetectNextWord, start");
          }
          i = this.jdField_a_of_type_JavaUtilList.size();
          if (i == 0) {
            return;
          }
          if (this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkReciteDataWordInfo == null)
          {
            WordInfo localWordInfo = b();
            if (localWordInfo != null) {
              this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkReciteDataWordInfo = localWordInfo;
            }
          }
          else
          {
            if (this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkReciteDataWordInfo != null) {
              break;
            }
            b();
            continue;
          }
          this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkReciteDataWordInfo = a();
        }
        finally {}
        while ((this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkReciteDataWordInfo != null) && (!this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkReciteDataWordInfo.isNormalWord()))
        {
          this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkReciteDataWordInfo.color = WordInfo.COLOR_DEFAULT;
          localObject2 = this.jdField_a_of_type_AndroidOsHandler.obtainMessage();
          ((Message)localObject2).what = 0;
          ((Message)localObject2).obj = this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkReciteDataWordInfo;
          this.jdField_a_of_type_AndroidOsHandler.sendMessage((Message)localObject2);
          this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkReciteDataWordInfo = a();
        }
      }
      if (!QLog.isColorLevel()) {
        break label774;
      }
      QLog.d("ReciteDetect.ReciteDetectManager", 2, String.format("背诵内容[%s]\n检测答案[%s]", new Object[] { this.jdField_a_of_type_JavaUtilList.toString(), this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkReciteDataWordInfo.pinyin2Detect.toString() }));
      break label774;
      if (i >= this.jdField_a_of_type_JavaUtilList.size()) {
        break label777;
      }
      localObject2 = (String)this.jdField_a_of_type_JavaUtilList.get(i);
      if (this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkReciteDataWordInfo.isPinyinDetectRight((String)localObject2))
      {
        this.d = 0;
        this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkReciteDataWordInfo.color = WordInfo.COLOR_DEFAULT;
        this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkReciteDataWordInfo.isDetected = true;
        localObject2 = this.jdField_a_of_type_AndroidOsHandler.obtainMessage();
        ((Message)localObject2).what = 0;
        ((Message)localObject2).obj = this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkReciteDataWordInfo;
        this.jdField_a_of_type_AndroidOsHandler.sendMessage((Message)localObject2);
        if (i >= this.h)
        {
          this.g += i - this.h;
          if (QLog.isColorLevel()) {
            QLog.d("ReciteDetect.ReciteDetectManager", 2, "detected！！！mLastSentenceSubLen:" + this.g);
          }
        }
        for (this.h = 0;; this.h -= i)
        {
          this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkReciteDataWordInfo = null;
          localObject2 = this.jdField_a_of_type_JavaUtilList.toString();
          this.jdField_a_of_type_JavaUtilList = this.jdField_a_of_type_JavaUtilList.subList(i + 1, this.jdField_a_of_type_JavaUtilList.size());
          localObject3 = this.jdField_a_of_type_JavaUtilList.toString();
          if (QLog.isColorLevel()) {
            QLog.d("ReciteDetect.ReciteDetectManager", 2, String.format("识别结果,对 || 对背诵内容进行截断，为下一个字检测所用：\n before[%s], \n after[%s], removeIndex[%d]", new Object[] { localObject2, localObject3, Integer.valueOf(i) }));
          }
          if (paramInt >= this.jdField_a_of_type_ComTencentMobileqqAppTroopManager.a.jdField_b_of_type_Int) {
            break;
          }
          a(paramInt + 1);
          break;
        }
      }
      if (i <= this.jdField_a_of_type_ComTencentMobileqqAppTroopManager.a.c) {
        break label767;
      }
      this.d += 1;
      this.jdField_b_of_type_Int += 1;
      this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkReciteDataWordInfo.color = WordInfo.COLOR_WRONG;
      this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkReciteDataWordInfo.isDetected = true;
      localObject2 = this.jdField_a_of_type_AndroidOsHandler.obtainMessage();
      ((Message)localObject2).what = 0;
      ((Message)localObject2).obj = this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkReciteDataWordInfo;
      this.jdField_a_of_type_AndroidOsHandler.sendMessage((Message)localObject2);
      this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkReciteDataWordInfo = null;
      if (QLog.isColorLevel()) {
        QLog.d("ReciteDetect.ReciteDetectManager", 2, String.format("识别结果,错||mErroCount[%d], continuousWrongNum[%d]", new Object[] { Integer.valueOf(this.jdField_b_of_type_Int), Integer.valueOf(this.d) }));
      }
      if (this.d < this.jdField_a_of_type_ComTencentMobileqqAppTroopManager.a.d) {
        break;
      }
      if (QLog.isColorLevel()) {
        QLog.d("ReciteDetect.ReciteDetectManager", 2, "repeatRecite");
      }
      a();
      localObject2 = this.jdField_a_of_type_AndroidOsHandler.obtainMessage();
      ((Message)localObject2).what = 1;
      this.jdField_a_of_type_AndroidOsHandler.sendMessage((Message)localObject2);
    } while (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null);
    Object localObject3 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    String str1 = this.jdField_a_of_type_JavaLangString;
    String str2 = this.jdField_a_of_type_JavaLangString;
    if (this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkReciteDataArticleInfo != null) {}
    for (Object localObject2 = this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkReciteDataArticleInfo.title;; localObject2 = "")
    {
      bbbp.a((QQAppInterface)localObject3, str1, "Grp_recite", "Norecognize_Recite_Again_Clk", 0, 0, new String[] { str2, "", localObject2, "" });
      break;
      if (paramInt >= this.jdField_a_of_type_ComTencentMobileqqAppTroopManager.a.jdField_b_of_type_Int) {
        break;
      }
      a(paramInt + 1);
      break;
      label767:
      i += 1;
      break label197;
      label774:
      i = 0;
      break label197;
      label777:
      break;
    }
  }
  
  protected void a(WordInfo paramWordInfo)
  {
    label274:
    for (;;)
    {
      try
      {
        Object localObject;
        if (this.jdField_a_of_type_JavaUtilArrayList.isEmpty())
        {
          localObject = null;
          if (localObject == null) {
            break label274;
          }
          if ((paramWordInfo.paragraphPos >= ((WordInfo)localObject).paragraphPos) && (paramWordInfo.wordPos > ((WordInfo)localObject).wordPos))
          {
            break label274;
            if ((paramWordInfo != null) && (paramWordInfo.paragraphPos < this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkReciteDataArticleInfo.paragraphs.size()) && (i != 0))
            {
              localObject = ((ParagraphInfo)this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkReciteDataArticleInfo.paragraphs.get(paramWordInfo.paragraphPos)).generateOrGetWordInfoList(paramWordInfo.paragraphPos);
              i = paramWordInfo.wordPos + 1;
              if (i < ((List)localObject).size())
              {
                WordInfo localWordInfo = (WordInfo)((List)localObject).get(i);
                if (QLog.isColorLevel()) {
                  QLog.d("ReciteDetect.ReciteDetectManager", 2, String.format("ifNextWordIsPunctuationThenShow：%s", new Object[] { localWordInfo.toString() }));
                }
                if (!localWordInfo.isNormalWord())
                {
                  localWordInfo.color = WordInfo.COLOR_DEFAULT;
                  this.jdField_a_of_type_Baaq.a(localWordInfo);
                  if ((this.e == paramWordInfo.wordPos) && (this.f == paramWordInfo.paragraphPos))
                  {
                    this.f += 1;
                    if (i == ((List)localObject).size() - 1) {
                      this.jdField_b_of_type_Boolean = true;
                    }
                  }
                  a(localWordInfo);
                }
              }
            }
          }
        }
        else
        {
          localObject = (WordInfo)this.jdField_a_of_type_JavaUtilArrayList.get(this.jdField_a_of_type_JavaUtilArrayList.size() - 1);
          continue;
        }
        int i = 0;
        continue;
        i = 1;
      }
      finally {}
    }
  }
  
  /* Error */
  protected WordInfo b()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 61	baan:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   6: invokevirtual 331	java/util/ArrayList:isEmpty	()Z
    //   9: ifne +19 -> 28
    //   12: aload_0
    //   13: getfield 61	baan:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   16: iconst_0
    //   17: invokevirtual 346	java/util/ArrayList:remove	(I)Ljava/lang/Object;
    //   20: checkcast 176	com/tencent/mobileqq/troop/homework/recite/data/WordInfo
    //   23: astore_1
    //   24: aload_0
    //   25: monitorexit
    //   26: aload_1
    //   27: areturn
    //   28: aconst_null
    //   29: astore_1
    //   30: goto -6 -> 24
    //   33: astore_1
    //   34: aload_0
    //   35: monitorexit
    //   36: aload_1
    //   37: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	38	0	this	baan
    //   23	7	1	localWordInfo	WordInfo
    //   33	4	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	24	33	finally
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_Boolean) {}
    do
    {
      return;
      this.jdField_a_of_type_Boolean = true;
      if (this.jdField_a_of_type_Baaq == null) {
        break;
      }
      Message localMessage = this.jdField_a_of_type_AndroidOsHandler.obtainMessage();
      localMessage.what = 2;
      this.jdField_a_of_type_AndroidOsHandler.sendMessage(localMessage);
    } while (!QLog.isColorLevel());
    QLog.d("ReciteDetect.ReciteDetectManager", 2, String.format("onCompleteRecite, mWordTotalCount[%d], mErroCount[%d], mRemindCount[%d]", new Object[] { Integer.valueOf(this.jdField_a_of_type_Int), Integer.valueOf(this.jdField_b_of_type_Int), Integer.valueOf(this.c) }));
    return;
    this.jdField_a_of_type_Int = 0;
    this.c = 0;
  }
  
  protected void b(double paramDouble, String[] paramArrayOfString)
  {
    int j = 0;
    for (;;)
    {
      String str1;
      ArrayList localArrayList;
      try
      {
        str1 = this.jdField_a_of_type_JavaUtilList.toString() + ",mLastSentenceSubLen:" + this.g;
        String str2;
        if (this.jdField_a_of_type_Double != paramDouble)
        {
          this.jdField_a_of_type_Double = paramDouble;
          this.g = 0;
          i = 0;
          localArrayList = new ArrayList(paramArrayOfString.length);
          if (j >= paramArrayOfString.length) {
            break label149;
          }
          str2 = paramArrayOfString[j];
          if (PinyinTextView.a(str2))
          {
            if (!QLog.isColorLevel()) {
              break label297;
            }
            QLog.d("ReciteDetect.ReciteDetectManager", 2, "背诵内容是标点符号，跳过");
            break label297;
          }
        }
        else
        {
          if (this.g == 0) {
            break label306;
          }
          j = this.g;
          i = 0;
          continue;
        }
        localArrayList.add(str2);
      }
      finally {}
      label149:
      if (i != 0)
      {
        if (this.h != 0) {
          break label258;
        }
        this.jdField_a_of_type_JavaUtilList.clear();
      }
      for (;;)
      {
        if (!localArrayList.isEmpty())
        {
          this.h = this.jdField_a_of_type_JavaUtilList.size();
          this.jdField_a_of_type_JavaUtilList.addAll(localArrayList);
        }
        if (QLog.isColorLevel()) {
          QLog.d("yellowye", 2, "recitingPinyinsList, 插入前：" + str1 + "\n插入后：" + this.jdField_a_of_type_JavaUtilList.toString());
        }
        return;
        label258:
        if (this.h <= this.jdField_a_of_type_JavaUtilList.size() - 1) {
          this.jdField_a_of_type_JavaUtilList = this.jdField_a_of_type_JavaUtilList.subList(0, this.h);
        }
      }
      label297:
      j += 1;
      continue;
      label306:
      int i = 1;
    }
  }
  
  public void c()
  {
    try
    {
      this.jdField_a_of_type_Double = 0.0D;
      this.jdField_a_of_type_Double = -1.0D;
      this.h = 0;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void d()
  {
    int i = 0;
    for (;;)
    {
      try
      {
        if (i < this.jdField_a_of_type_ComTencentMobileqqAppTroopManager.a.jdField_a_of_type_Int)
        {
          Object localObject2;
          if ((this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkReciteDataWordInfo != null) && (!this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkReciteDataWordInfo.isReminded))
          {
            localObject2 = this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkReciteDataWordInfo;
            if (localObject2 != null)
            {
              ((WordInfo)localObject2).color = -7829368;
              ((WordInfo)localObject2).isReminded = true;
              this.jdField_a_of_type_JavaUtilArrayList.add(localObject2);
              this.jdField_a_of_type_Baaq.a((WordInfo)localObject2);
              this.c += 1;
            }
          }
          else
          {
            WordInfo localWordInfo = a();
            localObject2 = localWordInfo;
            if (localWordInfo == null) {
              continue;
            }
            localObject2 = localWordInfo;
            if (localWordInfo.isNormalWord()) {
              continue;
            }
            localWordInfo.color = WordInfo.COLOR_DEFAULT;
            this.jdField_a_of_type_Baaq.a(localWordInfo);
            localWordInfo = a();
            continue;
          }
        }
        else
        {
          return;
        }
      }
      finally {}
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     baan
 * JD-Core Version:    0.7.0.1
 */