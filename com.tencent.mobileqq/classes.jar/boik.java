import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView.Adapter;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import com.tencent.mobileqq.app.ThreadManager;
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

public class boik
  extends RecyclerView.Adapter<boio>
  implements boiz
{
  private static final int jdField_a_of_type_Int = bgtn.a(9.0F);
  private boim jdField_a_of_type_Boim;
  private boin jdField_a_of_type_Boin;
  private List<AEEditorTextBean> jdField_a_of_type_JavaUtilList;
  private boolean jdField_a_of_type_Boolean = bnzc.a();
  private int b;
  private int c = -1;
  private int d = -1;
  private int e;
  
  public boik(List<AEEditorTextBean> paramList, boim paramboim, boin paramboin)
  {
    this.jdField_a_of_type_JavaUtilList = paramList;
    this.jdField_a_of_type_Boim = paramboim;
    this.jdField_a_of_type_Boin = paramboin;
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
  
  private void a(boio paramboio, boolean paramBoolean)
  {
    if (paramboio == null) {
      return;
    }
    if (paramBoolean)
    {
      paramboio.c.setVisibility(0);
      paramboio.d.setVisibility(0);
      paramboio.jdField_a_of_type_DovComQqImAeViewAEDownLoadingView.setVisibility(0);
      return;
    }
    paramboio.c.setVisibility(8);
    paramboio.d.setVisibility(8);
    paramboio.jdField_a_of_type_DovComQqImAeViewAEDownLoadingView.setVisibility(8);
  }
  
  public boio a(ViewGroup paramViewGroup, int paramInt)
  {
    return new boio(this, LayoutInflater.from(paramViewGroup.getContext()).inflate(2131558561, paramViewGroup, false));
  }
  
  public void a(int paramInt)
  {
    this.e = paramInt;
  }
  
  public void a(boio paramboio, int paramInt)
  {
    AEEditorTextBean localAEEditorTextBean = (AEEditorTextBean)this.jdField_a_of_type_JavaUtilList.get(paramInt);
    int i = (ScreenUtil.getScreenWidth() - bgtn.a(10.0F) * 2) / 5;
    a(paramboio.jdField_b_of_type_AndroidViewView, i);
    a(paramboio.jdField_a_of_type_AndroidViewView, i * 128 / 156);
    if ((this.jdField_a_of_type_JavaUtilList != null) && (this.jdField_a_of_type_JavaUtilList.size() > paramInt)) {
      bnyl.a().a().g = ((AEEditorTextBean)this.jdField_a_of_type_JavaUtilList.get(paramInt)).id;
    }
    bnyh.a().u();
    if (paramInt == this.c)
    {
      i = 1;
      if ((localAEEditorTextBean.type != 1) || (this.e != 2) || (!bofw.a().a(localAEEditorTextBean.id)) || (localAEEditorTextBean.pagThumbFilePath == null) || (!new File(localAEEditorTextBean.pagThumbFilePath).exists())) {
        break label274;
      }
      paramboio.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(BitmapUtils.decodeBitmap(localAEEditorTextBean.thumbPath, true));
      label189:
      if (!localAEEditorTextBean.isDownloading) {
        break label315;
      }
      a(paramboio, true);
      paramboio.jdField_a_of_type_DovComQqImAeViewAEDownLoadingView.setProgress(localAEEditorTextBean.progress);
      label216:
      if ((i == 0) || (!localAEEditorTextBean.usable)) {
        break label324;
      }
      paramboio.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
    }
    for (;;)
    {
      paramboio.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(new boil(this, paramInt, localAEEditorTextBean, paramboio));
      EventCollector.getInstance().onRecyclerBindViewHolder(paramboio, paramInt, getItemId(paramInt));
      return;
      i = 0;
      break;
      label274:
      zlx.a(paramboio.jdField_a_of_type_AndroidWidgetImageView, localAEEditorTextBean.thumbUrl, zlx.a(paramboio.jdField_a_of_type_AndroidWidgetImageView.getContext(), 67.0F), zlx.a(paramboio.jdField_a_of_type_AndroidWidgetImageView.getContext(), 67.0F), null, null);
      break label189;
      label315:
      a(paramboio, false);
      break label216;
      label324:
      paramboio.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
    }
  }
  
  public void a(AEEditorTextBean paramAEEditorTextBean, int paramInt)
  {
    ThreadManager.getUIHandler().post(new AETextStickerAdapter.2(this, paramAEEditorTextBean, paramInt));
  }
  
  public void a(AEEditorTextBean paramAEEditorTextBean, boolean paramBoolean, @Nullable AEEditorPagStickerConfig paramAEEditorPagStickerConfig)
  {
    bnzb.a("AETextStickerAdapter", "[onGetPagStickerConfig], succeeded=" + paramBoolean);
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
      bnzb.d("AETextStickerAdapter", "[findAndSelected] id is null");
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
        bnzb.d("AETextStickerAdapter", "[findAndSelected] success id:" + paramString);
        b(i);
        return;
      }
      bnzb.d("AETextStickerAdapter", "[findAndSelected] failed id:" + paramString);
      return;
    }
  }
  
  public void b(int paramInt)
  {
    d(paramInt);
    notifyDataSetChanged();
    if (this.jdField_a_of_type_Boim != null) {
      this.jdField_a_of_type_Boim.c(paramInt);
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
      while (this.jdField_a_of_type_Boin != null)
      {
        this.jdField_a_of_type_Boin.a(bool1, (String)localObject);
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
 * Qualified Name:     boik
 * JD-Core Version:    0.7.0.1
 */