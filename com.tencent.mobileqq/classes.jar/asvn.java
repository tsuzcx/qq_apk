import com.tencent.mobileqq.filemanager.data.FavFileInfo;
import java.util.Comparator;

class asvn
  implements Comparator<FavFileInfo>
{
  asvn(asvm paramasvm) {}
  
  public int a(FavFileInfo paramFavFileInfo1, FavFileInfo paramFavFileInfo2)
  {
    if (paramFavFileInfo2.c > paramFavFileInfo1.c) {
      return 1;
    }
    if (paramFavFileInfo2.c < paramFavFileInfo1.c) {
      return -1;
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     asvn
 * JD-Core Version:    0.7.0.1
 */