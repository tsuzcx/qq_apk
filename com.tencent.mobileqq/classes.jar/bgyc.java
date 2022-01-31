import common.config.service.QzoneConfig;

public class bgyc
{
  public static String a(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    return QzoneConfig.getInstance().getConfig("H5Url", "CoverStore", "https://h5.qzone.qq.com/bgcover/index?_wv=2098179&qua={qua}&_proxy=1").replace("{uin}", paramString3).replace("{hostUin}", paramString4).replace("{qua}", bgxr.a()).replace("{pb}", "").replace("{clicktime}", String.valueOf(System.currentTimeMillis())).replace("{from}", paramString1).replace("{page}", paramString2);
  }
  
  public static String a(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    return QzoneConfig.getInstance().getConfig("H5Url", "CoverPreview", "https://h5.qzone.qq.com/bgstore/detail/{coverid}?_wv=2098179&from={from}&page={page}&qua={qua}&router=detail&coverid={coverid}&uin={uin}&hostUin={hostUin}&_proxy=1").replace("{qua}", bgxr.a()).replace("{pb}", "").replace("{from}", paramString1).replace("{page}", paramString2).replace("{coverid}", paramString3).replace("{uin}", paramString4).replace("{hostUin}", paramString5);
  }
  
  public static String a(String paramString1, String paramString2, String paramString3, boolean paramBoolean)
  {
    paramString1 = QzoneConfig.getInstance().getConfig("H5Url", "PhotoWallUrl", "https://h5.qzone.qq.com/bgstore/photoWall?_wv=2098179&uin={uin}&hostUin={hostUin}&from={from}&page=1&qua={qua}&router=photoWall&_proxy=1").replace("{uin}", paramString1).replace("{hostUin}", paramString2).replace("{qua}", bgxr.a());
    paramString2 = new StringBuilder().append("");
    if (paramBoolean) {}
    for (int i = 1;; i = 0) {
      return paramString1.replace("{isPhotoWall}", i).replace("{clicktime}", String.valueOf(System.currentTimeMillis())).replace("{from}", paramString3);
    }
  }
  
  public static String b(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    return QzoneConfig.getInstance().getConfig("H5Url", "MusicCoverPreview", "https://h5.qzone.qq.com/musicCover/preview?id={coverid}&_wv=2098179&from={from}&page={page}&qua={qua}&router=detail&coverid={coverid}&uin={uin}&hostUin={hostUin}&_proxy=1").replace("{qua}", bgxr.a()).replace("{pb}", "").replace("{from}", paramString1).replace("{page}", paramString2).replace("{coverid}", paramString3).replace("{uin}", paramString4).replace("{hostUin}", paramString5);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     bgyc
 * JD-Core Version:    0.7.0.1
 */