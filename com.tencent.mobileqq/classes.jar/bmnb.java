import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView.Adapter;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import com.tencent.biz.qqstory.utils.UIUtils;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.tavsticker.utils.ScreenUtil;
import com.tencent.ttpic.baseutils.bitmap.BitmapUtils;
import dov.com.qq.im.ae.view.AEDownLoadingView;
import dov.com.qq.im.aeeditor.manage.AEEditorPagStickerConfig;
import dov.com.qq.im.aeeditor.module.text.AEEditorTextBean;
import dov.com.qq.im.aeeditor.module.text.AETextStickerAdapter.2;
import dov.com.qq.im.aeeditor.module.text.AETextStickerAdapter.3;
import dov.com.qq.im.aeeditor.module.text.AETextStickerAdapter.4;
import java.io.File;
import java.util.Iterator;
import java.util.List;
import mqq.os.MqqHandler;

public class bmnb
  extends RecyclerView.Adapter<bmnf>
  implements bmnq
{
  private static final int jdField_a_of_type_Int = ViewUtils.dip2px(9.0F);
  private bmnd jdField_a_of_type_Bmnd;
  private bmne jdField_a_of_type_Bmne;
  private List<AEEditorTextBean> jdField_a_of_type_JavaUtilList;
  private boolean jdField_a_of_type_Boolean = bmby.a();
  private int b;
  private int c = -1;
  private int d = -1;
  private int e;
  
  public bmnb(List<AEEditorTextBean> paramList, bmnd parambmnd, bmne parambmne)
  {
    this.jdField_a_of_type_JavaUtilList = paramList;
    this.jdField_a_of_type_Bmnd = parambmnd;
    this.jdField_a_of_type_Bmne = parambmne;
  }
  
  private void a(View paramView, int paramInt)
  {
    if (paramView == null) {
      return;
    }
    ViewGroup.LayoutParams localLayoutParams = paramView.getLayoutParams();
    localLayoutParams.width = paramInt;
    localLayoutParams.height = paramInt;
    paramView.setLayoutParams(localLayoutParams);
  }
  
  private void a(bmnf parambmnf, boolean paramBoolean)
  {
    if (parambmnf == null) {
      return;
    }
    if (paramBoolean)
    {
      parambmnf.c.setVisibility(0);
      parambmnf.d.setVisibility(0);
      parambmnf.jdField_a_of_type_DovComQqImAeViewAEDownLoadingView.setVisibility(0);
      return;
    }
    parambmnf.c.setVisibility(8);
    parambmnf.d.setVisibility(8);
    parambmnf.jdField_a_of_type_DovComQqImAeViewAEDownLoadingView.setVisibility(8);
  }
  
  public bmnf a(ViewGroup paramViewGroup, int paramInt)
  {
    return new bmnf(this, LayoutInflater.from(paramViewGroup.getContext()).inflate(2131558565, paramViewGroup, false));
  }
  
  public void a()
  {
    try
    {
      this.b -= 1;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void a(int paramInt)
  {
    this.e = paramInt;
  }
  
  public void a(bmnf parambmnf, int paramInt)
  {
    AEEditorTextBean localAEEditorTextBean = (AEEditorTextBean)this.jdField_a_of_type_JavaUtilList.get(paramInt);
    int i = (ScreenUtil.getScreenWidth() - ViewUtils.dip2px(10.0F) * 2) / 5;
    a(parambmnf.jdField_b_of_type_AndroidViewView, i);
    a(parambmnf.jdField_a_of_type_AndroidViewView, i * 128 / 156);
    if ((this.jdField_a_of_type_JavaUtilList != null) && (this.jdField_a_of_type_JavaUtilList.size() > paramInt)) {
      bmbg.a().a().g = ((AEEditorTextBean)this.jdField_a_of_type_JavaUtilList.get(paramInt)).id;
    }
    bmbc.a().t();
    if (paramInt == this.c)
    {
      i = 1;
      if ((localAEEditorTextBean.type != 1) || (this.e != 2) || (!bmkn.a().a(localAEEditorTextBean.id)) || (localAEEditorTextBean.pagThumbFilePath == null) || (!new File(localAEEditorTextBean.pagThumbFilePath).exists())) {
        break label274;
      }
      parambmnf.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(BitmapUtils.decodeBitmap(localAEEditorTextBean.thumbPath, true));
      label189:
      if (!localAEEditorTextBean.isDownloading) {
        break label317;
      }
      a(parambmnf, true);
      parambmnf.jdField_a_of_type_DovComQqImAeViewAEDownLoadingView.setProgress(localAEEditorTextBean.progress);
      label216:
      if ((i == 0) || (!localAEEditorTextBean.usable)) {
        break label326;
      }
      parambmnf.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
    }
    for (;;)
    {
      parambmnf.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(new bmnc(this, paramInt, localAEEditorTextBean, parambmnf));
      EventCollector.getInstance().onRecyclerBindViewHolder(parambmnf, paramInt, getItemId(paramInt));
      return;
      i = 0;
      break;
      label274:
      UIUtils.setViewByURL(parambmnf.jdField_a_of_type_AndroidWidgetImageView, localAEEditorTextBean.thumbUrl, UIUtils.dip2px(parambmnf.jdField_a_of_type_AndroidWidgetImageView.getContext(), 67.0F), UIUtils.dip2px(parambmnf.jdField_a_of_type_AndroidWidgetImageView.getContext(), 67.0F), null, null);
      break label189;
      label317:
      a(parambmnf, false);
      break label216;
      label326:
      parambmnf.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
    }
  }
  
  public void a(AEEditorTextBean paramAEEditorTextBean, int paramInt)
  {
    ThreadManager.getUIHandler().post(new AETextStickerAdapter.2(this, paramAEEditorTextBean, paramInt));
  }
  
  public void a(AEEditorTextBean paramAEEditorTextBean, boolean paramBoolean, @Nullable AEEditorPagStickerConfig paramAEEditorPagStickerConfig)
  {
    bmbx.a("AETextStickerAdapter", "[onGetPagStickerConfig], succeeded=" + paramBoolean);
    ThreadManager.getUIHandler().post(new AETextStickerAdapter.4(this, paramBoolean, paramAEEditorPagStickerConfig, paramAEEditorTextBean));
  }
  
  public void a(AEEditorTextBean paramAEEditorTextBean, boolean paramBoolean, @NonNull String paramString)
  {
    ThreadManager.getUIHandler().post(new AETextStickerAdapter.3(this, paramAEEditorTextBean, paramBoolean));
  }
  
  public void a(String paramString)
  {
    if (TextUtils.isEmpty(paramString))
    {
      b(-1);
      bmbx.d("AETextStickerAdapter", "[findAndSelected] id is null");
      return;
    }
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    int i = -1;
    int k;
    while (localIterator.hasNext())
    {
      AEEditorTextBean localAEEditorTextBean = (AEEditorTextBean)localIterator.next();
      j = i + 1;
      i = j;
      if (localAEEditorTextBean.id != null)
      {
        i = j;
        if (localAEEditorTextBean.id.equals(paramString))
        {
          k = 1;
          i = j;
        }
      }
    }
    for (int j = k;; j = 0)
    {
      if (j != 0)
      {
        bmbx.d("AETextStickerAdapter", "[findAndSelected] success id:" + paramString);
        b(i);
        return;
      }
      bmbx.d("AETextStickerAdapter", "[findAndSelected] failed id:" + paramString);
      return;
    }
  }
  
  public void b(int paramInt)
  {
    d(paramInt);
    notifyDataSetChanged();
    if (this.jdField_a_of_type_Bmnd != null) {
      this.jdField_a_of_type_Bmnd.c(paramInt);
    }
  }
  
  public void c(int paramInt)
  {
    this.b = paramInt;
  }
  
  public void d(int paramInt)
  {
    boolean bool2 = false;
    boolean bool1 = false;
    this.c = paramInt;
    if ((this.jdField_a_of_type_JavaUtilList == null) || (this.jdField_a_of_type_JavaUtilList.size() <= this.c) || (this.c < 0)) {}
    for (;;)
    {
      return;
      Object localObject = (AEEditorTextBean)this.jdField_a_of_type_JavaUtilList.get(this.c);
      if (localObject != null)
      {
        if ((((AEEditorTextBean)localObject).type == 1) || (((AEEditorTextBean)localObject).type == 0)) {
          bool1 = true;
        }
        localObject = ((AEEditorTextBean)localObject).id;
      }
      while (this.jdField_a_of_type_Bmne != null)
      {
        this.jdField_a_of_type_Bmne.a(bool1, (String)localObject);
        return;
        localObject = "";
        bool1 = bool2;
      }
    }
  }
  
  public int getItemCount()
  {
    return this.jdField_a_of_type_JavaUtilList.size();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bmnb
 * JD-Core Version:    0.7.0.1
 */