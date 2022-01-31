import android.os.MessageQueue.IdleHandler;
import com.tencent.mobileqq.gallery.model.GalleryBaseData;
import com.tencent.mobileqq.gallery.model.pic.AIOPicData;

class aqoz
  implements MessageQueue.IdleHandler
{
  aqoz(aqox paramaqox) {}
  
  public boolean queueIdle()
  {
    Object localObject = this.a.a.a();
    if ((localObject != null) && (((aqmg)localObject).a != null) && (((aqmg)localObject).a.a() == 1))
    {
      localObject = (AIOPicData)((aqmg)localObject).a;
      aqmo localaqmo = new aqmo();
      if ((localObject != null) && (localaqmo.a((AIOPicData)localObject, 4)) && (localaqmo.a((AIOPicData)localObject, 4) == null))
      {
        this.a.e(true);
        this.a.j();
      }
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aqoz
 * JD-Core Version:    0.7.0.1
 */