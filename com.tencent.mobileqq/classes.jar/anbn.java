import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.os.SystemClock;
import cooperation.qzone.util.GifCoder;
import java.io.File;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/apollo/screenshot/ApolloGifEncoder;", "Lcom/tencent/mobileqq/apollo/screenshot/IApolloScreenshotEncoder;", "tempFilePath", "", "(Ljava/lang/String;)V", "gifEncoder", "Lcooperation/qzone/util/GifCoder;", "picList", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "addFrame", "", "pixels", "", "width", "", "height", "close", "encode", "", "outputFilePath", "frameTime", "init", "removePicList", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class anbn
  implements anbq
{
  private final GifCoder jdField_a_of_type_CooperationQzoneUtilGifCoder;
  private final String jdField_a_of_type_JavaLangString;
  private final ArrayList<String> jdField_a_of_type_JavaUtilArrayList;
  
  public anbn(@NotNull String paramString)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_a_of_type_CooperationQzoneUtilGifCoder = new GifCoder();
  }
  
  public void a()
  {
    this.jdField_a_of_type_CooperationQzoneUtilGifCoder.setUseOrignalBitmap(true);
  }
  
  public void a(@NotNull byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfByte, "pixels");
    Bitmap localBitmap = Bitmap.createBitmap(paramInt1, paramInt2, Bitmap.Config.ARGB_8888);
    localBitmap.copyPixelsFromBuffer((Buffer)ByteBuffer.wrap(paramArrayOfByte));
    long l = SystemClock.elapsedRealtime();
    paramArrayOfByte = this.jdField_a_of_type_JavaLangString + File.separator + l + ".jpg";
    bheg.a(anlz.a(localBitmap, -1), new File(paramArrayOfByte));
    this.jdField_a_of_type_JavaUtilArrayList.add(paramArrayOfByte);
  }
  
  public boolean a(@NotNull String paramString, int paramInt)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "outputFilePath");
    return this.jdField_a_of_type_CooperationQzoneUtilGifCoder.encodeGif(paramString, this.jdField_a_of_type_JavaUtilArrayList, paramInt, true);
  }
  
  public void b()
  {
    this.jdField_a_of_type_CooperationQzoneUtilGifCoder.closeEncoder();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     anbn
 * JD-Core Version:    0.7.0.1
 */