import com.tencent.mobileqq.nearby.now.model.Comments.Comment;
import com.tencent.qphone.base.util.QLog;

class avcu
  implements auxz
{
  avcu(avcs paramavcs) {}
  
  public void a(Comments.Comment paramComment)
  {
    if (avcs.a(this.a) != null)
    {
      avcs.a(this.a).a(paramComment);
      if (QLog.isColorLevel()) {
        QLog.d("nearby.bindphone", 2, "onPublishSuccess");
      }
    }
  }
  
  public void a(Comments.Comment paramComment, int paramInt, String paramString)
  {
    if (avcs.a(this.a) != null)
    {
      avcs.a(this.a).a(paramComment, paramInt, paramString);
      if (QLog.isColorLevel()) {
        QLog.d("nearby.bindphone", 2, "onDataNotAvailable, code=" + paramInt + ", tip=" + paramString + ", comment=" + paramComment);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     avcu
 * JD-Core Version:    0.7.0.1
 */