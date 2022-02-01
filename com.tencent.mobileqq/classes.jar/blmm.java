import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.tav.core.AssetExportSession;
import com.tencent.tavcut.exporter.MovieExporter.VideoCompressListener;
import dov.com.qq.im.ae.album.data.AEAlbumVideoModel;
import dov.com.qq.im.ae.album.logic.AEPhotoListLogicBase.18.1;
import dov.com.qq.im.ae.album.logic.AEPhotoListLogicBase.18.2;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import mqq.os.MqqHandler;

public class blmm
  implements MovieExporter.VideoCompressListener
{
  blmm(blmi paramblmi, int paramInt, AEAlbumVideoModel paramAEAlbumVideoModel) {}
  
  public void onCompressCanceled()
  {
    bmbx.b("AEPhotoListLogicBase", "batchCompress---cancel, index=" + this.jdField_a_of_type_Int);
    if (blmi.a(this.jdField_a_of_type_Blmi) != null) {
      blmi.a(this.jdField_a_of_type_Blmi).countDown();
    }
  }
  
  public void onCompressError(AssetExportSession paramAssetExportSession)
  {
    bmbx.b("AEPhotoListLogicBase", "batchCompress---error, index=" + this.jdField_a_of_type_Int + ", path=" + this.jdField_a_of_type_DovComQqImAeAlbumDataAEAlbumVideoModel.getPath());
    blmi.b(this.jdField_a_of_type_Blmi, true);
    ThreadManager.getUIHandler().post(new AEPhotoListLogicBase.18.2(this));
    if (blmi.a(this.jdField_a_of_type_Blmi) != null) {
      blmi.a(this.jdField_a_of_type_Blmi).countDown();
    }
  }
  
  public void onCompressFinish(String paramString)
  {
    bmbx.b("AEPhotoListLogicBase", "batchCompress---finish, index=" + this.jdField_a_of_type_Int + ", compressed path=" + paramString);
    blmi.a(this.jdField_a_of_type_Blmi).put(this.jdField_a_of_type_DovComQqImAeAlbumDataAEAlbumVideoModel.getPath(), paramString);
    this.jdField_a_of_type_DovComQqImAeAlbumDataAEAlbumVideoModel.setPath(paramString);
    if (blmi.a(this.jdField_a_of_type_Blmi) != null) {
      blmi.a(this.jdField_a_of_type_Blmi).countDown();
    }
  }
  
  public void onCompressStart() {}
  
  public void onCompressing(float paramFloat)
  {
    ThreadManager.getUIHandler().post(new AEPhotoListLogicBase.18.1(this, paramFloat));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     blmm
 * JD-Core Version:    0.7.0.1
 */