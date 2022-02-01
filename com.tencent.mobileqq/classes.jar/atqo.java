import android.content.Context;
import android.content.res.Resources;
import android.graphics.BitmapFactory.Options;
import android.text.TextUtils;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.face.FaceDecoder;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.utils.FileUtils;
import java.util.List;

public class atqo
  extends bcjc
{
  private BitmapFactory.Options a = new BitmapFactory.Options();
  
  public atqo(FaceDecoder paramFaceDecoder)
  {
    super(paramFaceDecoder);
  }
  
  public void a(bcfj parambcfj, bcnt parambcnt)
  {
    parambcnt.a().setMaxWidth(800);
    Object localObject = (atqj)parambcfj;
    ImageView localImageView = parambcnt.b();
    localImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
    localImageView.setImageDrawable(null);
    localImageView.setBackgroundDrawable(null);
    if (((atqj)localObject).a == null) {
      return;
    }
    FileManagerEntity localFileManagerEntity = (FileManagerEntity)((atqj)localObject).a.get(0);
    int i = auea.a(localFileManagerEntity.fileName);
    if ((i == 0) || (i == 2))
    {
      if (FileUtils.fileExistsAndNotEmpty(localFileManagerEntity.strThumbPath)) {
        localObject = localFileManagerEntity.strThumbPath;
      }
      for (;;)
      {
        localObject = URLDrawable.URLDrawableOptions.obtain();
        ((URLDrawable.URLDrawableOptions)localObject).mRequestHeight = parambcnt.b().getHeight();
        ((URLDrawable.URLDrawableOptions)localObject).mRequestWidth = parambcnt.b().getWidth();
        parambcnt = parambcnt.d();
        if ((parambcnt != null) && (!TextUtils.isEmpty(parambcfj.d())))
        {
          parambcnt.setText(parambcfj.d());
          parambcnt.setVisibility(0);
        }
        parambcfj = aues.a(localFileManagerEntity);
        if (parambcfj == null) {
          break;
        }
        parambcfj = URLDrawable.getDrawable(parambcfj, (URLDrawable.URLDrawableOptions)localObject);
        if (parambcfj == null) {
          localImageView.setImageDrawable(localImageView.getContext().getResources().getDrawable(2130844268));
        }
        localImageView.setImageDrawable(parambcfj);
        return;
        if (FileUtils.fileExistsAndNotEmpty(localFileManagerEntity.strLargeThumPath))
        {
          localObject = localFileManagerEntity.strLargeThumPath;
        }
        else
        {
          if (!FileUtils.fileExistsAndNotEmpty(localFileManagerEntity.getFilePath())) {
            break label265;
          }
          localFileManagerEntity.getFilePath();
        }
      }
      label265:
      localObject = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
      if (localFileManagerEntity.getCloudType() == 1) {
        localObject = ((QQAppInterface)localObject).getFileManagerEngine().a(localFileManagerEntity, 7);
      }
    }
    for (;;)
    {
      if (TextUtils.isEmpty((CharSequence)localObject))
      {
        localImageView.setImageDrawable(BaseApplicationImpl.getContext().getResources().getDrawable(2130844268));
        return;
        if (localFileManagerEntity.getCloudType() == 2) {
          localObject = ((QQAppInterface)localObject).getFileManagerEngine().a(localFileManagerEntity.WeiYunFileId, localFileManagerEntity.strLargeThumPath, 3, localFileManagerEntity);
        }
      }
      else
      {
        localFileManagerEntity.strThumbPath = ((String)localObject);
        break;
        auea.a(localImageView, localFileManagerEntity);
        return;
      }
      localObject = "";
    }
  }
  
  public void b(bcfj parambcfj, bcnt parambcnt)
  {
    super.b(parambcfj, parambcnt);
    if ((parambcnt.a() != null) && (!TextUtils.isEmpty(parambcfj.a())))
    {
      parambcnt.a().setVisibility(0);
      parambcnt.a().setText(parambcfj.a());
    }
    if ((parambcnt.b() != null) && (!TextUtils.isEmpty(parambcfj.b())))
    {
      parambcnt.b().setVisibility(0);
      parambcnt.b().setText(parambcfj.b());
    }
    if ((parambcnt.c() != null) && (!TextUtils.isEmpty(parambcfj.c())))
    {
      parambcnt.c().setVisibility(0);
      parambcnt.c().setText(parambcfj.c());
    }
    if ((parambcfj.d() == null) && (parambcnt.d() != null)) {
      parambcnt.d().setVisibility(8);
    }
    if ((parambcnt.d() != null) && (parambcfj.d() != null))
    {
      parambcnt.d().setVisibility(0);
      parambcnt.d().setText(parambcfj.d());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     atqo
 * JD-Core Version:    0.7.0.1
 */