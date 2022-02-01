import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.biz.videostory.widget.view.smartmusicview.VsMusicItemInfo;
import java.util.LinkedList;
import java.util.List;

public class bpis
{
  public static final List<bpis> a;
  public int a;
  private VsMusicItemInfo a;
  public boolean a;
  public final int b;
  public final boolean b;
  public final int c;
  
  static
  {
    jdField_a_of_type_JavaUtilList = a();
  }
  
  public bpis(@NonNull VsMusicItemInfo paramVsMusicItemInfo, boolean paramBoolean, int paramInt)
  {
    this(paramVsMusicItemInfo, paramBoolean, paramInt, false, -1);
  }
  
  public bpis(@NonNull VsMusicItemInfo paramVsMusicItemInfo, boolean paramBoolean1, int paramInt1, boolean paramBoolean2, int paramInt2)
  {
    this.jdField_a_of_type_ComTencentBizVideostoryWidgetViewSmartmusicviewVsMusicItemInfo = paramVsMusicItemInfo;
    this.jdField_a_of_type_Boolean = paramBoolean1;
    this.jdField_a_of_type_Int = 0;
    this.jdField_b_of_type_Int = paramInt1;
    this.jdField_b_of_type_Boolean = paramBoolean2;
    this.c = paramInt2;
  }
  
  @NonNull
  private static List<bpis> a()
  {
    LinkedList localLinkedList = new LinkedList();
    int i = 0;
    if (i < 6)
    {
      Object localObject = new VsMusicItemInfo();
      ((VsMusicItemInfo)localObject).mSongMid = ("fakeMid" + (i + 1));
      ((VsMusicItemInfo)localObject).mMusicName = "";
      ((VsMusicItemInfo)localObject).mUrl = "";
      ((VsMusicItemInfo)localObject).mAlbumUrl = "";
      if (i == 0) {}
      for (localObject = new bpis((VsMusicItemInfo)localObject, false, 1);; localObject = new bpis((VsMusicItemInfo)localObject, false, 0))
      {
        localLinkedList.add(localObject);
        i += 1;
        break;
      }
    }
    return localLinkedList;
  }
  
  @NonNull
  private String f()
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
  public String d()
  {
    if (this.jdField_a_of_type_ComTencentBizVideostoryWidgetViewSmartmusicviewVsMusicItemInfo == null) {
      return "";
    }
    if (this.jdField_a_of_type_ComTencentBizVideostoryWidgetViewSmartmusicviewVsMusicItemInfo.b == null) {
      return "";
    }
    return this.jdField_a_of_type_ComTencentBizVideostoryWidgetViewSmartmusicviewVsMusicItemInfo.b;
  }
  
  @NonNull
  public String e()
  {
    if (this.jdField_a_of_type_ComTencentBizVideostoryWidgetViewSmartmusicviewVsMusicItemInfo == null) {
      return "LRC";
    }
    if (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentBizVideostoryWidgetViewSmartmusicviewVsMusicItemInfo.a)) {
      return "LRC";
    }
    return this.jdField_a_of_type_ComTencentBizVideostoryWidgetViewSmartmusicviewVsMusicItemInfo.a;
  }
  
  @NonNull
  public String toString()
  {
    return "{songMid:" + a() + ", songName:" + f() + ", songUrl:" + b() + ", selected:" + this.jdField_a_of_type_Boolean + ", downloadStatus:" + this.jdField_a_of_type_Int + ", itemType:" + this.jdField_b_of_type_Int + "}";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bpis
 * JD-Core Version:    0.7.0.1
 */