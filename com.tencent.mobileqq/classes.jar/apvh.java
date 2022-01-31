import android.os.MessageQueue.IdleHandler;
import com.tencent.mobileqq.gallery.model.GalleryBaseData;
import com.tencent.mobileqq.gallery.model.pic.AIOPicData;

class apvh
  implements MessageQueue.IdleHandler
{
  apvh(apux paramapux) {}
  
  public boolean queueIdle()
  {
    Object localObject = this.a.a.a();
    if ((localObject != null) && (((apsr)localObject).a != null) && (((apsr)localObject).a.a() == 1))
    {
      localObject = (AIOPicData)((apsr)localObject).a;
      apsz localapsz = new apsz();
      if ((localObject != null) && (localapsz.a((AIOPicData)localObject, 4)) && (localapsz.a((AIOPicData)localObject, 4) == null))
      {
        this.a.e(true);
        this.a.j();
      }
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     apvh
 * JD-Core Version:    0.7.0.1
 */