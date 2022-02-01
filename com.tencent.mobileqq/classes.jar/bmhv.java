import com.microrapid.opencv.ImageMainColorData;
import dov.com.qq.im.aeeditor.module.edit.AEEditorImageEditFragment;
import java.util.Comparator;

public class bmhv
  implements Comparator<ImageMainColorData>
{
  public bmhv(AEEditorImageEditFragment paramAEEditorImageEditFragment) {}
  
  public int a(ImageMainColorData paramImageMainColorData1, ImageMainColorData paramImageMainColorData2)
  {
    int i = 0;
    if (paramImageMainColorData1.area > paramImageMainColorData2.area) {
      i = -1;
    }
    while (paramImageMainColorData1.area >= paramImageMainColorData2.area) {
      return i;
    }
    return 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bmhv
 * JD-Core Version:    0.7.0.1
 */