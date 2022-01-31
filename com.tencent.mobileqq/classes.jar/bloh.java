import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.biz.videostory.widget.view.smartmusicview.VsMusicItemInfo;
import java.util.LinkedList;
import java.util.List;

public class bloh
{
  public static final List<bloh> a;
  public int a;
  private VsMusicItemInfo a;
  public boolean a;
  public final boolean b;
  
  static
  {
    jdField_a_of_type_JavaUtilList = a();
  }
  
  public bloh(@NonNull VsMusicItemInfo paramVsMusicItemInfo, boolean paramBoolean)
  {
    this(paramVsMusicItemInfo, paramBoolean, false);
  }
  
  public bloh(@NonNull VsMusicItemInfo paramVsMusicItemInfo, boolean paramBoolean1, boolean paramBoolean2)
  {
    this.jdField_a_of_type_ComTencentBizVideostoryWidgetViewSmartmusicviewVsMusicItemInfo = paramVsMusicItemInfo;
    this.jdField_a_of_type_Boolean = paramBoolean1;
    this.jdField_a_of_type_Int = 0;
    this.b = paramBoolean2;
  }
  
  @NonNull
  private static List<bloh> a()
  {
    LinkedList localLinkedList = new LinkedList();
    int i = 0;
    while (i < 5)
    {
      VsMusicItemInfo localVsMusicItemInfo = new VsMusicItemInfo();
      localVsMusicItemInfo.mSongMid = ("fakeMid" + (i + 1));
      localVsMusicItemInfo.mMusicName = "";
      localVsMusicItemInfo.mUrl = "";
      localVsMusicItemInfo.mAlbumUrl = "";
      localLinkedList.add(new bloh(localVsMusicItemInfo, false, true));
      i += 1;
    }
    return localLinkedList;
  }
  
  @NonNull
  private String d()
  {
    if (this.jdField_a_of_type_ComTencentBizVideostoryWidgetViewSmartmusicviewVsMusicItemInfo == null) {
      return "";
    }
    if (this.jdField_a_of_type_ComTencentBizVideostoryWidgetViewSmartmusicviewVsMusicItemInfo.mMusicName == null) {
      return "";
    }
    return this.jdField_a_of_type_ComTencentBizVideostoryWidgetViewSmartmusicviewVsMusicItemInfo.mMusicName;
  }
  
  public int a()
  {
    if (this.jdField_a_of_type_ComTencentBizVideostoryWidgetViewSmartmusicviewVsMusicItemInfo == null) {
      return 0;
    }
    return this.jdField_a_of_type_ComTencentBizVideostoryWidgetViewSmartmusicviewVsMusicItemInfo.musicStart;
  }
  
  @NonNull
  public String a()
  {
    if (this.jdField_a_of_type_ComTencentBizVideostoryWidgetViewSmartmusicviewVsMusicItemInfo == null) {
      return "";
    }
    if (this.jdField_a_of_type_ComTencentBizVideostoryWidgetViewSmartmusicviewVsMusicItemInfo.mSongMid == null) {
      return "";
    }
    return this.jdField_a_of_type_ComTencentBizVideostoryWidgetViewSmartmusicviewVsMusicItemInfo.mSongMid;
  }
  
  public boolean a()
  {
    return TextUtils.isEmpty(a());
  }
  
  public int b()
  {
    if (this.jdField_a_of_type_ComTencentBizVideostoryWidgetViewSmartmusicviewVsMusicItemInfo == null) {
      return 0;
    }
    return this.jdField_a_of_type_ComTencentBizVideostoryWidgetViewSmartmusicviewVsMusicItemInfo.musicDuration;
  }
  
  @NonNull
  public String b()
  {
    if (this.jdField_a_of_type_ComTencentBizVideostoryWidgetViewSmartmusicviewVsMusicItemInfo == null) {
      return "";
    }
    if (this.jdField_a_of_type_ComTencentBizVideostoryWidgetViewSmartmusicviewVsMusicItemInfo.mUrl == null) {
      return "";
    }
    return this.jdField_a_of_type_ComTencentBizVideostoryWidgetViewSmartmusicviewVsMusicItemInfo.mUrl;
  }
  
  @NonNull
  public String c()
  {
    if (this.jdField_a_of_type_ComTencentBizVideostoryWidgetViewSmartmusicviewVsMusicItemInfo == null) {
      return "";
    }
    if (this.jdField_a_of_type_ComTencentBizVideostoryWidgetViewSmartmusicviewVsMusicItemInfo.mAlbumUrl == null) {
      return "";
    }
    return this.jdField_a_of_type_ComTencentBizVideostoryWidgetViewSmartmusicviewVsMusicItemInfo.mAlbumUrl;
  }
  
  @NonNull
  public String toString()
  {
    return "{songMid:" + a() + ", songName:" + d() + ", songUrl:" + b() + ", selected:" + this.jdField_a_of_type_Boolean + ", downloadStatus:" + this.jdField_a_of_type_Int + "}";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bloh
 * JD-Core Version:    0.7.0.1
 */