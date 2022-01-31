import com.tencent.mobileqq.nearby.now.model.Comments.Comment;
import com.tencent.qphone.base.util.QLog;

class avhd
  implements avci
{
  avhd(avhb paramavhb) {}
  
  public void a(Comments.Comment paramComment)
  {
    if (avhb.a(this.a) != null)
    {
      avhb.a(this.a).a(paramComment);
      if (QLog.isColorLevel()) {
        QLog.d("nearby.bindphone", 2, "onPublishSuccess");
      }
    }
  }
  
  public void a(Comments.Comment paramComment, int paramInt, String paramString)
  {
    if (avhb.a(this.a) != null)
    {
      avhb.a(this.a).a(paramComment, paramInt, paramString);
      if (QLog.isColorLevel()) {
        QLog.d("nearby.bindphone", 2, "onDataNotAvailable, code=" + paramInt + ", tip=" + paramString + ", comment=" + paramComment);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     avhd
 * JD-Core Version:    0.7.0.1
 */