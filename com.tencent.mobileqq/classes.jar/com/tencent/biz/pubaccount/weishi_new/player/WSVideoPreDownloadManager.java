package com.tencent.biz.pubaccount.weishi_new.player;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.ThreadManager;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import vgd;
import vgj;
import vgl;
import vgn;
import vgo;
import vgp;
import vgu;
import vgw;
import vgy;
import vgz;
import vhe;
import vmp;

public class WSVideoPreDownloadManager
  implements vgl
{
  private Context jdField_a_of_type_AndroidContentContext;
  private String jdField_a_of_type_JavaLangString;
  private List<vgp> jdField_a_of_type_JavaUtilList;
  private Set<String> jdField_a_of_type_JavaUtilSet;
  private vgj jdField_a_of_type_Vgj;
  private vgo jdField_a_of_type_Vgo;
  private vgw jdField_a_of_type_Vgw;
  private vgy jdField_a_of_type_Vgy;
  private vgz jdField_a_of_type_Vgz;
  
  public WSVideoPreDownloadManager(Context paramContext)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_Vgj = new vgj();
    this.jdField_a_of_type_Vgj.a(this);
    if (!this.jdField_a_of_type_Vgj.a())
    {
      this.jdField_a_of_type_Vgj.a();
      return;
    }
    c();
    d();
  }
  
  private vgu a(String paramString, int paramInt)
  {
    if (this.jdField_a_of_type_Vgw == null) {
      return null;
    }
    vgu localvgu = this.jdField_a_of_type_Vgw.a();
    localvgu.a(vgd.a(paramString), paramString, 101, paramInt);
    return localvgu;
  }
  
  private void a(vgp paramvgp)
  {
    if ((paramvgp == null) || (TextUtils.isEmpty(paramvgp.b))) {}
    vgy localvgy;
    do
    {
      return;
      localvgy = this.jdField_a_of_type_Vgy;
      if (localvgy == null)
      {
        vmp.d("WS_VIDEO_PRE_DL", "[WSVideoPreDownloadManager.java][innerDoPreDownload] start preload ERROR preDownloader == null!");
        return;
      }
      vmp.e("WS_VIDEO_PRE_DL", "[WSVideoPreDownloadManager.java][innerDoPreDownload] START DOWNLOAD!! duration:" + paramvgp.a + ", title:" + paramvgp.c + ", url:" + paramvgp.b);
    } while (TextUtils.isEmpty(paramvgp.b));
    localvgy.a(a(paramvgp.b, paramvgp.a));
  }
  
  private void c()
  {
    this.jdField_a_of_type_Vgw = vhe.a().a();
    this.jdField_a_of_type_Vgy = this.jdField_a_of_type_Vgw.a(BaseApplicationImpl.getContext());
    vmp.e("WS_VIDEO_PRE_DL", "[WSVideoPreDownloadManager.java][initCacheMgr] mPreDownloader=" + this.jdField_a_of_type_Vgy);
    if (this.jdField_a_of_type_Vgy == null) {}
  }
  
  private void d()
  {
    if (this.jdField_a_of_type_Vgy == null) {
      return;
    }
    this.jdField_a_of_type_JavaUtilSet = new HashSet();
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    vmp.e("WS_VIDEO_PRE_DL", "[WSVideoPreDownloadManager.java][initSerialPreDownload] setPreloadCallback");
    this.jdField_a_of_type_Vgy.a(new vgn(this));
  }
  
  private void e()
  {
    vmp.e("WS_VIDEO_PRE_DL", "[WSVideoPreDownloadManager.java][releaseSerialPreDownload]");
    if (this.jdField_a_of_type_Vgy != null)
    {
      this.jdField_a_of_type_Vgy.a(null);
      this.jdField_a_of_type_Vgy.b();
    }
  }
  
  /* Error */
  private void f()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 52	com/tencent/biz/pubaccount/weishi_new/player/WSVideoPreDownloadManager:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   4: astore_2
    //   5: aload_2
    //   6: ifnull +172 -> 178
    //   9: aload_2
    //   10: invokeinterface 196 1 0
    //   15: ifle +163 -> 178
    //   18: aload_2
    //   19: iconst_0
    //   20: invokeinterface 200 2 0
    //   25: checkcast 92	vgp
    //   28: astore_1
    //   29: aload_2
    //   30: iconst_0
    //   31: invokeinterface 203 2 0
    //   36: pop
    //   37: aload_1
    //   38: ifnull +13 -> 51
    //   41: aload_1
    //   42: getfield 95	vgp:b	Ljava/lang/String;
    //   45: invokestatic 101	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   48: ifeq +41 -> 89
    //   51: aload_0
    //   52: invokespecial 147	com/tencent/biz/pubaccount/weishi_new/player/WSVideoPreDownloadManager:f	()V
    //   55: return
    //   56: astore_2
    //   57: aconst_null
    //   58: astore_1
    //   59: ldc 103
    //   61: new 112	java/lang/StringBuilder
    //   64: dup
    //   65: invokespecial 113	java/lang/StringBuilder:<init>	()V
    //   68: ldc 205
    //   70: invokevirtual 119	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   73: aload_2
    //   74: invokevirtual 208	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   77: invokevirtual 119	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   80: invokevirtual 135	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   83: invokestatic 110	vmp:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   86: goto -49 -> 37
    //   89: aload_0
    //   90: aload_1
    //   91: getfield 95	vgp:b	Ljava/lang/String;
    //   94: putfield 48	com/tencent/biz/pubaccount/weishi_new/player/WSVideoPreDownloadManager:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   97: aload_0
    //   98: aload_0
    //   99: getfield 48	com/tencent/biz/pubaccount/weishi_new/player/WSVideoPreDownloadManager:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   102: invokevirtual 211	com/tencent/biz/pubaccount/weishi_new/player/WSVideoPreDownloadManager:a	(Ljava/lang/String;)Z
    //   105: ifeq +40 -> 145
    //   108: ldc 103
    //   110: new 112	java/lang/StringBuilder
    //   113: dup
    //   114: invokespecial 113	java/lang/StringBuilder:<init>	()V
    //   117: ldc 213
    //   119: invokevirtual 119	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   122: aload_1
    //   123: getfield 129	vgp:c	Ljava/lang/String;
    //   126: invokevirtual 119	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   129: invokevirtual 135	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   132: invokestatic 137	vmp:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   135: aload_0
    //   136: aconst_null
    //   137: putfield 48	com/tencent/biz/pubaccount/weishi_new/player/WSVideoPreDownloadManager:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   140: aload_0
    //   141: invokespecial 147	com/tencent/biz/pubaccount/weishi_new/player/WSVideoPreDownloadManager:f	()V
    //   144: return
    //   145: ldc 103
    //   147: new 112	java/lang/StringBuilder
    //   150: dup
    //   151: invokespecial 113	java/lang/StringBuilder:<init>	()V
    //   154: ldc 215
    //   156: invokevirtual 119	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   159: aload_1
    //   160: getfield 129	vgp:c	Ljava/lang/String;
    //   163: invokevirtual 119	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   166: invokevirtual 135	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   169: invokestatic 137	vmp:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   172: aload_0
    //   173: aload_1
    //   174: invokespecial 217	com/tencent/biz/pubaccount/weishi_new/player/WSVideoPreDownloadManager:a	(Lvgp;)V
    //   177: return
    //   178: ldc 103
    //   180: ldc 219
    //   182: invokestatic 137	vmp:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   185: return
    //   186: astore_2
    //   187: goto -128 -> 59
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	190	0	this	WSVideoPreDownloadManager
    //   28	146	1	localvgp	vgp
    //   4	26	2	localList	List
    //   56	18	2	localException1	java.lang.Exception
    //   186	1	2	localException2	java.lang.Exception
    // Exception table:
    //   from	to	target	type
    //   18	29	56	java/lang/Exception
    //   29	37	186	java/lang/Exception
  }
  
  public void a()
  {
    vmp.e("WS_VIDEO_PRE_DL", "[WSVideoPreDownloadManager.java][destroy]");
    ThreadManager.post(new WSVideoPreDownloadManager.1(this), 5, null, true);
    if (this.jdField_a_of_type_Vgj != null)
    {
      this.jdField_a_of_type_Vgj.b();
      this.jdField_a_of_type_Vgj = null;
    }
  }
  
  public void a(int paramInt)
  {
    a(paramInt, true);
  }
  
  public void a(int paramInt, boolean paramBoolean)
  {
    if (this.jdField_a_of_type_Vgo == null) {}
    List localList;
    do
    {
      return;
      if (this.jdField_a_of_type_Vgy == null) {
        break;
      }
      localList = this.jdField_a_of_type_Vgo.a(paramInt, paramBoolean);
    } while ((localList == null) || (localList.size() <= 0));
    vmp.f("WS_VIDEO_PRE_DL", ">>>>>>[WSVideoPreDownloadManager.java][requestPreDownload] START!! preDownloadList size:" + localList.size());
    ThreadManager.post(new WSVideoPreDownloadManager.PreDownloadSerialTask(this, localList), 5, null, true);
    return;
    vmp.d("WS_VIDEO_PRE_DL", "[WSVideoPreDownloadManager.java][requestPreDownload] is off or mPreDownloader is null, return!");
  }
  
  public void a(vgo paramvgo)
  {
    this.jdField_a_of_type_Vgo = paramvgo;
  }
  
  public void a(vgz paramvgz)
  {
    this.jdField_a_of_type_Vgz = paramvgz;
  }
  
  public void a(boolean paramBoolean)
  {
    c();
    d();
  }
  
  public boolean a(String paramString)
  {
    if (this.jdField_a_of_type_Vgy == null) {}
    while ((!this.jdField_a_of_type_Vgy.a(a(paramString, 0))) && ((this.jdField_a_of_type_JavaUtilSet == null) || (!this.jdField_a_of_type_JavaUtilSet.contains(paramString)))) {
      return false;
    }
    return true;
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_Vgy != null) {
      this.jdField_a_of_type_Vgy.a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.player.WSVideoPreDownloadManager
 * JD-Core Version:    0.7.0.1
 */