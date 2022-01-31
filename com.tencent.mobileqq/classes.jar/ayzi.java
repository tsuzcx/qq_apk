import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.mobileqq.troop.homework.recite.data.ArticleInfo;
import com.tencent.mobileqq.troop.homework.recite.data.ParagraphInfo;
import com.tencent.mobileqq.troop.homework.recite.data.WordInfo;
import java.util.List;

class ayzi
  extends Handler
{
  ayzi(ayzh paramayzh, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    if (this.a.jdField_a_of_type_Ayzk == null) {}
    WordInfo localWordInfo;
    do
    {
      return;
      switch (paramMessage.what)
      {
      default: 
        return;
      case 0: 
        localWordInfo = (WordInfo)paramMessage.obj;
        this.a.jdField_a_of_type_Ayzk.a(localWordInfo);
        if (this.a.jdField_a_of_type_ComTencentMobileqqTroopHomeworkReciteDataWordInfo == null) {
          this.a.a(localWordInfo);
        }
        break;
      }
    } while ((!localWordInfo.isDetected) || (localWordInfo.paragraphPos != this.a.jdField_a_of_type_ComTencentMobileqqTroopHomeworkReciteDataArticleInfo.paragraphs.size() - 1));
    paramMessage = ((ParagraphInfo)this.a.jdField_a_of_type_ComTencentMobileqqTroopHomeworkReciteDataArticleInfo.paragraphs.get(localWordInfo.paragraphPos)).generateOrGetWordInfoList(localWordInfo.paragraphPos);
    int i = localWordInfo.wordPos + 1;
    label148:
    if (i < paramMessage.size())
    {
      localWordInfo = (WordInfo)paramMessage.get(i);
      if ((localWordInfo == null) || (!localWordInfo.isNormalWord())) {}
    }
    for (i = 0; i != 0; i = 1)
    {
      this.a.b();
      return;
      i += 1;
      break label148;
      this.a.jdField_a_of_type_Ayzk.g();
      return;
      this.a.jdField_a_of_type_Ayzk.a(this.a.jdField_a_of_type_Int, this.a.b, this.a.c);
      this.a.jdField_a_of_type_Int = 0;
      this.a.c = 0;
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     ayzi
 * JD-Core Version:    0.7.0.1
 */