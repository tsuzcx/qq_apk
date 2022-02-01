import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.tav.core.AssetExportSession;
import com.tencent.tavcut.exporter.MovieExporter.VideoCompressListener;
import dov.com.qq.im.ae.album.data.AEAlbumVideoModel;
import dov.com.qq.im.ae.album.logic.AEPhotoListLogicBase.18.1;
import dov.com.qq.im.ae.album.logic.AEPhotoListLogicBase.18.2;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import mqq.os.MqqHandler;

public class bmzv
  implements MovieExporter.VideoCompressListener
{
  bmzv(bmzr parambmzr, int paramInt, AEAlbumVideoModel paramAEAlbumVideoModel) {}
  
  public void onCompressCanceled()
  {
    bnrh.b("AEPhotoListLogicBase", "batchCompress---cancel, index=" + this.jdField_a_of_type_Int);
    if (bmzr.a(this.jdField_a_of_type_Bmzr) != null) {
      bmzr.a(this.jdField_a_of_type_Bmzr).countDown();
    }
  }
  
  public void onCompressError(AssetExportSession paramAssetExportSession)
  {
    bnrh.b("AEPhotoListLogicBase", "batchCompress---error, index=" + this.jdField_a_of_type_Int + ", path=" + this.jdField_a_of_type_DovComQqImAeAlbumDataAEAlbumVideoModel.getPath());
    bmzr.b(this.jdField_a_of_type_Bmzr, true);
    ThreadManager.getUIHandler().post(new AEPhotoListLogicBase.18.2(this));
    if (bmzr.a(this.jdField_a_of_type_Bmzr) != null) {
      bmzr.a(this.jdField_a_of_type_Bmzr).countDown();
    }
  }
  
  public void onCompressFinish(String paramString)
  {
    bnrh.b("AEPhotoListLogicBase", "batchCompress---finish, index=" + this.jdField_a_of_type_Int + ", compressed path=" + paramString);
    bmzr.a(this.jdField_a_of_type_Bmzr).put(this.jdField_a_of_type_DovComQqImAeAlbumDataAEAlbumVideoModel.getPath(), paramString);
    this.jdField_a_of_type_DovComQqImAeAlbumDataAEAlbumVideoModel.setPath(paramString);
    if (bmzr.a(this.jdField_a_of_type_Bmzr) != null) {
      bmzr.a(this.jdField_a_of_type_Bmzr).countDown();
    }
  }
  
  public void onCompressStart() {}
  
  public void onCompressing(float paramFloat)
  {
    ThreadManager.getUIHandler().post(new AEPhotoListLogicBase.18.1(this, paramFloat));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bmzv
 * JD-Core Version:    0.7.0.1
 */