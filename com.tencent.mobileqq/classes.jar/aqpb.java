import android.os.MessageQueue.IdleHandler;
import com.tencent.mobileqq.gallery.model.GalleryBaseData;
import com.tencent.mobileqq.gallery.model.pic.AIOPicData;

class aqpb
  implements MessageQueue.IdleHandler
{
  aqpb(aqoz paramaqoz) {}
  
  public boolean queueIdle()
  {
    Object localObject = this.a.a.a();
    if ((localObject != null) && (((aqmi)localObject).a != null) && (((aqmi)localObject).a.a() == 1))
    {
      localObject = (AIOPicData)((aqmi)localObject).a;
      aqmq localaqmq = new aqmq();
      if ((localObject != null) && (localaqmq.a((AIOPicData)localObject, 4)) && (localaqmq.a((AIOPicData)localObject, 4) == null))
      {
        this.a.e(true);
        this.a.j();
      }
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aqpb
 * JD-Core Version:    0.7.0.1
 */