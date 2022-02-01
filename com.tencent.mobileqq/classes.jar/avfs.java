import com.tencent.mobileqq.app.BaseActivity;

class avfs
  extends amsu
{
  avfs(avfq paramavfq) {}
  
  protected void onUpdateDelFriend(boolean paramBoolean, Object paramObject)
  {
    super.onUpdateDelFriend(paramBoolean, paramObject);
    paramObject = String.valueOf(paramObject);
    if ((paramBoolean) && (paramObject.equals(avfq.a(this.a).a())))
    {
      avfq.a(avfq.a(this.a), 0, String.valueOf(paramObject));
      if (avfq.a(this.a) != null) {
        avfq.a(this.a).finish();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     avfs
 * JD-Core Version:    0.7.0.1
 */