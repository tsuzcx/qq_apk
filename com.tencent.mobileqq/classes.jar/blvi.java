import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.os.Handler;
import android.os.Looper;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import com.tencent.mobileqq.troop.data.TroopBarPOI;
import com.tencent.qphone.base.util.QLog;
import com.tribe.async.dispatch.Dispatcher;
import com.tribe.async.dispatch.IEventReceiver;
import dov.com.qq.im.capture.paster.PasterDataManager.1;
import dov.com.qq.im.capture.view.StaticStickerProviderView;
import dov.com.tencent.biz.qqstory.takevideo.doodle.model.DoodleEmojiItem;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;

public class blvi
  extends blrr
  implements IEventReceiver, uva<uwr>, uxy
{
  public static AtomicBoolean a;
  private Context jdField_a_of_type_AndroidContentContext;
  protected Handler a;
  private blvm jdField_a_of_type_Blvm;
  protected bmmb a;
  public bmsf a;
  protected bmvw a;
  protected bmwc a;
  protected Runnable a;
  public CopyOnWriteArrayList<bmvv> a;
  private uwo jdField_a_of_type_Uwo;
  public uxz a;
  public boolean a;
  private boolean b;
  
  static
  {
    jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
  }
  
  public blvi()
  {
    this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
    this.jdField_a_of_type_Uxz = null;
    this.jdField_a_of_type_JavaLangRunnable = new PasterDataManager.1(this);
    this.jdField_a_of_type_Bmsf = new blvj(this);
  }
  
  private void a(String paramString1, String paramString2, boolean paramBoolean)
  {
    if ((paramString1 != null) && (this.jdField_a_of_type_Bmvw != null) && (!paramString1.equals(this.jdField_a_of_type_Bmvw.g))) {
      this.jdField_a_of_type_Bmvw.g = paramString1;
    }
    if ((paramString2 != null) && (this.jdField_a_of_type_Bmwc != null) && (!paramString2.equals(this.jdField_a_of_type_Bmwc.f))) {}
    for (int i = 1;; i = 0)
    {
      if ((this.jdField_a_of_type_Bmwc != null) && (i != 0))
      {
        this.jdField_a_of_type_Bmwc.f = paramString2;
        paramString1 = this.jdField_a_of_type_Bmwc.jdField_a_of_type_JavaUtilList.iterator();
        while (paramString1.hasNext()) {
          ((bmwd)paramString1.next()).jdField_b_of_type_JavaLangString = paramString2;
        }
        if (paramBoolean) {
          this.jdField_a_of_type_Bmmb.a(this.jdField_a_of_type_Bmwc);
        }
      }
      if (this.jdField_a_of_type_Bmvw != null)
      {
        if (i != 0)
        {
          this.jdField_a_of_type_Bmvw.f = paramString2;
          paramString1 = this.jdField_a_of_type_Bmvw.jdField_a_of_type_JavaUtilList.iterator();
          while (paramString1.hasNext())
          {
            bmvz localbmvz = (bmvz)paramString1.next();
            if (localbmvz.jdField_a_of_type_Boolean) {
              localbmvz.l = paramString2;
            }
          }
        }
        paramString1 = this.jdField_a_of_type_Bmvw.jdField_a_of_type_JavaUtilList.iterator();
        while (paramString1.hasNext())
        {
          paramString2 = (bmvz)paramString1.next();
          if ((paramString2.jdField_a_of_type_Int == 7) && (!this.jdField_a_of_type_Bmvw.g.equals(paramString2.i)) && (this.jdField_a_of_type_Bmvw.jdField_a_of_type_JavaUtilMap != null)) {
            a(this.jdField_a_of_type_Bmvw.jdField_a_of_type_JavaUtilMap, this.jdField_a_of_type_Bmvw.g, paramString2);
          }
        }
        if (paramBoolean) {
          this.jdField_a_of_type_Bmmb.a(this.jdField_a_of_type_Bmvw);
        }
      }
      return;
    }
  }
  
  private void a(Map<String, Map<String, bmvx>> paramMap, String paramString, bmvz parambmvz)
  {
    if (parambmvz.a() != null) {
      parambmvz.a().c();
    }
    Map localMap = (Map)paramMap.get(parambmvz.h);
    if (localMap != null)
    {
      paramMap = (bmvx)localMap.get(paramString);
      if (paramMap != null) {
        break label94;
      }
      paramMap = (bmvx)localMap.get("default");
    }
    label94:
    for (;;)
    {
      if (paramMap != null)
      {
        parambmvz.g = paramMap.jdField_a_of_type_JavaLangString;
        parambmvz.e = paramMap.jdField_b_of_type_JavaLangString;
        parambmvz.f = paramMap.c;
      }
      return;
    }
  }
  
  private void a(uwr paramuwr)
  {
    if (paramuwr != null)
    {
      this.jdField_a_of_type_Bmvw.c = paramuwr.jdField_a_of_type_Int;
      if (paramuwr.jdField_a_of_type_JavaLangString != null)
      {
        paramuwr = paramuwr.jdField_a_of_type_JavaLangString.split("\\|");
        if ((paramuwr != null) && (paramuwr.length == 2))
        {
          this.jdField_a_of_type_Bmvw.h = paramuwr[0];
          this.jdField_a_of_type_Bmvw.i = paramuwr[1];
        }
        paramuwr = this.jdField_a_of_type_Bmvw.jdField_a_of_type_JavaUtilList.iterator();
        while (paramuwr.hasNext())
        {
          bmvz localbmvz = (bmvz)paramuwr.next();
          if (localbmvz.jdField_a_of_type_Int == 6)
          {
            localbmvz.j = this.jdField_a_of_type_Bmvw.h;
            localbmvz.k = this.jdField_a_of_type_Bmvw.i;
            localbmvz.c = this.jdField_a_of_type_Bmvw.c;
          }
        }
      }
    }
  }
  
  private void a(uxs paramuxs, boolean paramBoolean)
  {
    wxe.b("PasterDataManager", "requestPoiList");
    uxt localuxt = (uxt)uwa.a(9);
    uxs localuxs = paramuxs;
    if (paramuxs == null) {
      localuxs = uxt.a();
    }
    if (paramBoolean)
    {
      localuxt.a(localuxs, null, this);
      return;
    }
    localuxt.a(localuxs, this.jdField_a_of_type_Uxz, this);
  }
  
  private void a(boolean paramBoolean)
  {
    a(null, paramBoolean);
  }
  
  private static void b(bmwf parambmwf, DoodleEmojiItem paramDoodleEmojiItem)
  {
    parambmwf.jdField_b_of_type_JavaLangString = paramDoodleEmojiItem.name;
    parambmwf.c = paramDoodleEmojiItem.icon;
    parambmwf.d = paramDoodleEmojiItem.download_icon;
    parambmwf.g = paramDoodleEmojiItem.getLocalEmojiFolderPath();
    parambmwf.e = paramDoodleEmojiItem.download_wording;
    parambmwf.jdField_a_of_type_Boolean = "1".equals(paramDoodleEmojiItem.random_position);
    parambmwf.a(paramDoodleEmojiItem.config);
    parambmwf.jdField_a_of_type_Int = paramDoodleEmojiItem.hide;
    parambmwf.jdField_b_of_type_Int = paramDoodleEmojiItem.mask;
  }
  
  private void e()
  {
    Object localObject = (bmru)uwa.a(39);
    ((bmru)localObject).c();
    String str;
    if (this.jdField_a_of_type_Bmwc == null)
    {
      this.jdField_a_of_type_Bmwc = new bmwc("0");
      this.jdField_a_of_type_Bmwc.jdField_b_of_type_Boolean = true;
      str = bmru.c((bmru)localObject, "0");
      localObject = bmru.a((bmru)localObject, "0");
      if ((TextUtils.isEmpty((CharSequence)localObject)) || (!bdin.g(this.jdField_a_of_type_AndroidContentContext))) {
        break label113;
      }
      this.jdField_a_of_type_Bmwc.c = ((String)localObject);
    }
    for (;;)
    {
      this.jdField_a_of_type_Bmwc.a(str);
      if (this.jdField_a_of_type_Bmvw == null) {
        this.jdField_a_of_type_Bmvw = new bmvw("2001");
      }
      return;
      label113:
      this.jdField_a_of_type_Bmwc.jdField_a_of_type_AndroidGraphicsDrawableDrawable = this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130846154);
    }
  }
  
  public bmmb a()
  {
    return this.jdField_a_of_type_Bmmb;
  }
  
  public bmvv a(String paramString)
  {
    return this.jdField_a_of_type_Bmmb.a(paramString);
  }
  
  public String a()
  {
    if (this.jdField_a_of_type_Bmwc != null) {
      return this.jdField_a_of_type_Bmwc.f;
    }
    return null;
  }
  
  public List<bmvv> a()
  {
    return a(false);
  }
  
  @NonNull
  public List<bmvv> a(boolean paramBoolean)
  {
    for (;;)
    {
      DoodleEmojiItem localDoodleEmojiItem;
      Object localObject3;
      try
      {
        if ((this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList != null) && (this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.size() != 0)) {
          break label752;
        }
        Object localObject1 = ((bmru)uwa.a(39)).a();
        this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList = new CopyOnWriteArrayList();
        localObject1 = ((Collection)localObject1).iterator();
        if (!((Iterator)localObject1).hasNext()) {
          break;
        }
        localDoodleEmojiItem = (DoodleEmojiItem)((Iterator)localObject1).next();
        if (localDoodleEmojiItem.type == 1)
        {
          localObject3 = new bmwf(localDoodleEmojiItem.pack_id);
          b((bmwf)localObject3, localDoodleEmojiItem);
          if (("1".equals(((bmwf)localObject3).jdField_a_of_type_JavaLangString)) && (!bdin.g(this.jdField_a_of_type_AndroidContentContext))) {
            ((bmwf)localObject3).jdField_a_of_type_AndroidGraphicsDrawableDrawable = this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130846011);
          }
          this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.add(localObject3);
          continue;
        }
        if (localDoodleEmojiItem.type != 2) {
          break label398;
        }
      }
      finally {}
      this.jdField_a_of_type_Bmwc.jdField_b_of_type_JavaLangString = localDoodleEmojiItem.name;
      if ((!TextUtils.isEmpty(localDoodleEmojiItem.icon)) && (bdin.g(this.jdField_a_of_type_AndroidContentContext))) {
        this.jdField_a_of_type_Bmwc.c = localDoodleEmojiItem.icon;
      }
      Object localObject4;
      while (localDoodleEmojiItem.mItemList != null)
      {
        this.jdField_a_of_type_Bmwc.jdField_a_of_type_JavaUtilList = localDoodleEmojiItem.mItemList;
        if (localDoodleEmojiItem.mItemList == null) {
          break;
        }
        wxe.b("PasterDataManager", "add doodle emoji location item name = " + this.jdField_a_of_type_Bmwc.f);
        localObject3 = localDoodleEmojiItem.mItemList.iterator();
        while (((Iterator)localObject3).hasNext())
        {
          localObject4 = (bmwd)((Iterator)localObject3).next();
          ((bmwd)localObject4).g = this.jdField_a_of_type_Bmwc.jdField_b_of_type_JavaLangString;
          ((bmwd)localObject4).jdField_b_of_type_JavaLangString = this.jdField_a_of_type_Bmwc.f;
        }
        this.jdField_a_of_type_Bmwc.jdField_a_of_type_AndroidGraphicsDrawableDrawable = this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130846154);
      }
      this.jdField_a_of_type_Bmwc.jdField_a_of_type_Boolean = "1".equals(localDoodleEmojiItem.random_position);
      this.jdField_a_of_type_Bmwc.jdField_a_of_type_Int = localDoodleEmojiItem.hide;
      this.jdField_a_of_type_Bmwc.jdField_b_of_type_Int = localDoodleEmojiItem.mask;
      this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.add(this.jdField_a_of_type_Bmwc);
      continue;
      label398:
      if (localDoodleEmojiItem.type == 3)
      {
        if (this.jdField_a_of_type_Bmvw == null) {
          this.jdField_a_of_type_Bmvw = new bmvw(localDoodleEmojiItem.pack_id);
        }
        for (;;)
        {
          this.jdField_a_of_type_Bmvw.jdField_b_of_type_JavaLangString = localDoodleEmojiItem.name;
          this.jdField_a_of_type_Bmvw.jdField_a_of_type_JavaUtilList = localDoodleEmojiItem.mInfoItemList;
          this.jdField_a_of_type_Bmvw.a(localDoodleEmojiItem.config);
          this.jdField_a_of_type_Bmvw.jdField_a_of_type_Int = localDoodleEmojiItem.hide;
          this.jdField_a_of_type_Bmvw.g = "default";
          this.jdField_a_of_type_Bmvw.c = -999;
          this.jdField_a_of_type_Bmvw.h = "--";
          this.jdField_a_of_type_Bmvw.i = "default";
          if (this.jdField_a_of_type_Bmvw.jdField_a_of_type_JavaUtilList == null) {
            break;
          }
          localObject3 = this.jdField_a_of_type_Bmvw.jdField_a_of_type_JavaUtilList.iterator();
          while (((Iterator)localObject3).hasNext())
          {
            localObject4 = (bmvz)((Iterator)localObject3).next();
            ((bmvz)localObject4).m = this.jdField_a_of_type_Bmvw.jdField_b_of_type_JavaLangString;
            if (bmwa.a(((bmvz)localObject4).jdField_a_of_type_Int)) {
              ((bmvz)localObject4).l = this.jdField_a_of_type_Bmvw.f;
            }
            if ((localDoodleEmojiItem.mCityRes != null) && (((bmvz)localObject4).jdField_a_of_type_Int == 7)) {
              a(localDoodleEmojiItem.mCityRes, this.jdField_a_of_type_Bmvw.g, (bmvz)localObject4);
            }
            if (((bmvz)localObject4).jdField_a_of_type_Int == 6)
            {
              ((bmvz)localObject4).c = this.jdField_a_of_type_Bmvw.c;
              ((bmvz)localObject4).j = this.jdField_a_of_type_Bmvw.h;
              ((bmvz)localObject4).k = this.jdField_a_of_type_Bmvw.i;
            }
          }
          this.jdField_a_of_type_Bmvw.jdField_a_of_type_JavaLangString = localDoodleEmojiItem.pack_id;
        }
        this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.add(this.jdField_a_of_type_Bmvw);
        this.jdField_a_of_type_Bmvw.jdField_a_of_type_JavaUtilMap = localDoodleEmojiItem.mCityRes;
      }
    }
    wxe.b("PasterDataManager", "getDoodleFacePackages, size = " + this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.size());
    jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(true);
    label752:
    if (paramBoolean)
    {
      StaticStickerProviderView.a(this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList);
      jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(true);
    }
    CopyOnWriteArrayList localCopyOnWriteArrayList = this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList;
    return localCopyOnWriteArrayList;
  }
  
  public void a(int paramInt, uxz paramuxz, List<TroopBarPOI> paramList)
  {
    wxe.b("PasterDataManager", "onPOIListRequestResult." + paramInt);
    if ((paramInt == 0) && (paramuxz != null))
    {
      this.jdField_a_of_type_Uxz = paramuxz;
      if ((paramList != null) && (paramList.size() > 0))
      {
        paramuxz = ((TroopBarPOI)paramList.get(0)).a();
        if (QLog.isColorLevel()) {
          QLog.d("PasterDataManager", 2, "onPOIListRequestResult " + paramuxz);
        }
        String str = ShortVideoUtils.c(QQStoryContext.a().getCurrentAccountUin());
        Iterator localIterator = paramList.iterator();
        while (localIterator.hasNext()) {
          if (((TroopBarPOI)localIterator.next()).a().equals(str)) {
            paramuxz = str;
          }
        }
      }
    }
    for (;;)
    {
      a(((TroopBarPOI)paramList.get(0)).jdField_b_of_type_JavaLangString, paramuxz, true);
      return;
    }
  }
  
  public void a(String paramString)
  {
    a(null, paramString, false);
  }
  
  public void a(uxs paramuxs)
  {
    this.jdField_a_of_type_Uwo = ((uwo)((uvb)uwa.a(20)).a(0));
    Object localObject = this.jdField_a_of_type_Uwo.a();
    if (localObject != null)
    {
      wxe.b("PasterDataManager", "get weather from cache.");
      a((uwr)localObject);
      return;
    }
    wxe.b("PasterDataManager", "get weather from net.");
    localObject = paramuxs;
    if (paramuxs == null) {
      localObject = uxt.a();
    }
    this.jdField_a_of_type_Uwo.a(this);
    this.jdField_a_of_type_Uwo.b((uxs)localObject);
  }
  
  public void a(boolean paramBoolean, Activity paramActivity)
  {
    if ((this.jdField_b_of_type_Boolean) && (this.jdField_a_of_type_Bmvw != null) && (!"default".equals(this.jdField_a_of_type_Bmvw.g)) && (!"--".equals(this.jdField_a_of_type_Bmvw.h))) {
      return;
    }
    new axpt(paramActivity, new blvk(this, paramBoolean)).a();
  }
  
  public void a(boolean paramBoolean, uwr paramuwr)
  {
    if (paramBoolean) {
      a(paramuwr);
    }
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_Blvm != null)
    {
      umc.a().unRegisterSubscriber(this.jdField_a_of_type_Blvm);
      this.jdField_a_of_type_Blvm = null;
    }
    if (this.jdField_a_of_type_Uwo != null) {
      this.jdField_a_of_type_Uwo.b(this);
    }
  }
  
  public void c()
  {
    this.jdField_a_of_type_AndroidContentContext = BaseApplicationImpl.getContext();
    this.jdField_a_of_type_Bmmb = new bmmb();
    e();
    this.jdField_a_of_type_Blvm = new blvm(this);
    umc.a().registerSubscriber(this.jdField_a_of_type_Blvm);
    if (QLog.isDevelopLevel()) {
      QLog.d("PasterDataManager", 4, "initPasterConfig");
    }
  }
  
  public void d()
  {
    this.jdField_b_of_type_Boolean = false;
  }
  
  public boolean isValidate()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     blvi
 * JD-Core Version:    0.7.0.1
 */