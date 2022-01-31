package com.tencent.component.media.image;

public class ImageTaskConst
{
  public static final String CLIENT_IP = "clientIp";
  public static final String DOWNLOAD_DETAIL_INFO = "downloadDetailInfo";
  public static final String ERROR_TYPE = "errType";
  public static final String EXCEPTION_CODE = "exceptionCode";
  public static final String FAIL_CODE = "failCode";
  public static final String FILE_PATH = "filePath";
  public static final int IMAGE_TASK_DECODE_EXCEPTION = 110;
  public static final int IMAGE_TASK_DECODE_GET_PHOTO_GIF_DRAWABLE_FAILED = 106;
  public static final int IMAGE_TASK_DECODE_GIF_DRAWABLE_FIALED = 107;
  public static final int IMAGE_TASK_DECODE_NORMAL_IMAGE_THROWABLE = 112;
  public static final int IMAGE_TASK_DECODE_OOM = 111;
  public static final int IMAGE_TASK_DECODE_SHARPP_GET_BITMAP_REFERENCE_FAILED = 105;
  public static final int IMAGE_TASK_DECODE_SHARPP_GET_GIF_DRAWABLE_FAILED = 103;
  public static final int IMAGE_TASK_DECODE_SHARPP_IMAGE_FILE = 104;
  public static final int IMAGE_TASK_DECODE_THROWABLE = 101;
  public static final int IMAGE_TASK_DOWNLOAD_SUCCEED_FILE_NOT_FOUND = 102;
  public static final int IMAGE_TASK_DOWNLOAD_SUCCEED_IMAGE_CAN_NOT_DECODE = 800;
  public static final int IMAGE_TASK_FAKE_FEED_LOCAL_IMAGE = 802;
  public static final int IMAGE_TASK_FETCH_CACHE_FAILED = 600;
  public static final int IMAGE_TASK_IMAGE_CAN_NOT_DOWNLOAD = 801;
  public static final int IMAGE_TASK_NO_NEXT_TASK = 700;
  public static final int IMAGE_TASK_NO_SUCH_FILE = 100;
  public static final String NOCACHE_CODE = "nocacheStatus";
  public static final String RESULT = "问题描述";
  public static final String SERVER_IP = "serverIp";
  public static final String URL = "url";
  
  public static String getImageTaskErrorDescription(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return "未知错误，请截屏给ianmao、kyloguo处理";
    case -99999: 
      return "下载器未知错误，请截屏给ianmao处理";
    case -99998: 
      return "超过尝试次数，请截屏给ianmao处理";
    case -99997: 
      return "网络请求失败，请截屏给ianmao处理";
    case -99996: 
      return "下载内容不是所需类型，请截屏给ianmao处理";
    case -4: 
      return "下载解码失败，请截屏给ianmao处理";
    case -3: 
      return "下载的文件长度与content-length不匹配，请截屏给ianmao处理";
    case -2: 
      return "no-cache，请截屏给ianmao处理";
    case -1: 
      return "非法格式，请截屏给ianmao处理";
    case 1: 
      return "FileNotFound，请截屏给ianmao处理";
    case 2: 
      return "下载过程出现IO异常，请截屏给ianmao处理";
    case 3: 
      return "下载过程出现oom，请截屏给ianmao处理";
    case 4: 
      return "未知exception，请截屏给ianmao处理";
    case 5: 
      return "系统网络库异常，请截屏给ianmao处理";
    case 6: 
      return "网络异常, 请恢复至正常网络后再试";
    case 7: 
      return "网络收发包超时，请截屏给ianmao处理";
    case 8: 
      return "HttpResponse解析失败，请截屏给ianmao处理";
    case 9: 
      return "域名解析失败，请截屏给ianmao处理";
    case 10: 
      return "连接超时，请截屏给ianmao处理";
    case 11: 
      return "发去的请求未收到服务端回应，请截屏给ianmao处理";
    case 12: 
      return "SSL证书校验失败，请截屏给ianmao处理";
    case 13: 
      return "本地连接池超时，请截屏给ianmao处理";
    case 14: 
      return "网络异常，服务端提前关闭连接，请截屏给ianmao处理";
    case 50001: 
      return "小米wifi导致的非法格式，请截屏给ianmao处理";
    case 50002: 
      return "Content-Length被中间网关篡改，请截屏给ianmao处理";
    case 50003: 
      return "磁盘空间不足，请清除部分无用的文件后再试";
    case 50004: 
      return "网络不可用，请恢复至正常的网络状态再试";
    case 50005: 
      return "网络不可达，请切换至正确的网络再试";
    case 50006: 
      return "没有网络访问权限，请切换至正确的网络再试";
    case 50007: 
      return "当前网络不可用，请恢复至正常网络后再试";
    case -2005: 
      return "后端超时，请截屏给ianmao处理";
    case -899: 
      return "图片已删除";
    case -5062: 
      return "图片不能查看（安全打击）";
    case 100: 
      return "文件不存在，请截屏给kyloguo处理";
    case 101: 
      return "解码过程异常，请截屏给kyloguo处理";
    case 102: 
      return "下载成功，但文件不存在，请截屏给kyloguo处理";
    case 103: 
      return "解码sharpP过程中，获取gif图失败，请截屏给kyloguo处理";
    case 104: 
      return "解码sharpP失败，请截屏给kyloguo处理";
    case 105: 
      return "获取bitmap reference失败,请清除缓存再试或截屏给kyloguo处理";
    case 106: 
      return "解码gif失败,请清除缓存再试或截屏给kyloguo处理";
    case 107: 
      return "解码gif异常,请清除缓存再试或截屏给kyloguo处理";
    case 110: 
      return "解码异常,请清除缓存再试或截屏给kyloguo处理";
    case 111: 
      return "解码oom，请截屏给kyloguo处理";
    case 112: 
      return "解码图片异常,请清除缓存再试或截屏给kyloguo处理";
    case 600: 
      return "获取图片缓存失败，没有后续下载任务可执行,请清除缓存再试或截屏给kyloguo处理";
    case 700: 
      return "解码失败,请清除缓存再试或截屏给kyloguo处理";
    case 800: 
      return "下载成功，未能正常解码,请清除缓存再试或截屏给kyloguo处理";
    case 801: 
      return "图片不能被下载，请截屏给kyloguo处理";
    }
    return "本地图片出错,请清除缓存再试或截屏给kyloguo处理";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.component.media.image.ImageTaskConst
 * JD-Core Version:    0.7.0.1
 */