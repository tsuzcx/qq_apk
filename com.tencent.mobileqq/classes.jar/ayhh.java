import com.tencent.mobileqq.nearby.now.model.Comments.Comment;
import com.tencent.qphone.base.util.QLog;

class ayhh
  implements aycl
{
  ayhh(ayhf paramayhf) {}
  
  public void a(Comments.Comment paramComment)
  {
    if (ayhf.a(this.a) != null)
    {
      ayhf.a(this.a).a(paramComment);
      if (QLog.isColorLevel()) {
        QLog.d("nearby.bindphone", 2, "onPublishSuccess");
      }
    }
  }
  
  public void a(Comments.Comment paramComment, int paramInt, String paramString)
  {
    if (ayhf.a(this.a) != null)
    {
      ayhf.a(this.a).a(paramComment, paramInt, paramString);
      if (QLog.isColorLevel()) {
        QLog.d("nearby.bindphone", 2, "onDataNotAvailable, code=" + paramInt + ", tip=" + paramString + ", comment=" + paramComment);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     ayhh
 * JD-Core Version:    0.7.0.1
 */