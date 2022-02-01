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
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import java.util.List;

public class atzy
  extends bcji
{
  private BitmapFactory.Options a = new BitmapFactory.Options();
  
  public atzy(aoof paramaoof)
  {
    super(paramaoof);
  }
  
  public void a(bcfr parambcfr, bcnz parambcnz)
  {
    parambcnz.a().setMaxWidth(800);
    Object localObject = (atzt)parambcfr;
    ImageView localImageView = parambcnz.b();
    localImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
    localImageView.setImageDrawable(null);
    localImageView.setBackgroundDrawable(null);
    if (((atzt)localObject).a == null) {
      return;
    }
    FileManagerEntity localFileManagerEntity = (FileManagerEntity)((atzt)localObject).a.get(0);
    int i = aunj.a(localFileManagerEntity.fileName);
    if ((i == 0) || (i == 2))
    {
      if (bhmi.b(localFileManagerEntity.strThumbPath)) {
        localObject = localFileManagerEntity.strThumbPath;
      }
      for (;;)
      {
        localObject = URLDrawable.URLDrawableOptions.obtain();
        ((URLDrawable.URLDrawableOptions)localObject).mRequestHeight = parambcnz.b().getHeight();
        ((URLDrawable.URLDrawableOptions)localObject).mRequestWidth = parambcnz.b().getWidth();
        parambcnz = parambcnz.d();
        if ((parambcnz != null) && (!TextUtils.isEmpty(parambcfr.d())))
        {
          parambcnz.setText(parambcfr.d());
          parambcnz.setVisibility(0);
        }
        parambcfr = auob.a(localFileManagerEntity);
        if (parambcfr == null) {
          break;
        }
        parambcfr = URLDrawable.getDrawable(parambcfr, (URLDrawable.URLDrawableOptions)localObject);
        if (parambcfr == null) {
          localImageView.setImageDrawable(localImageView.getContext().getResources().getDrawable(2130844316));
        }
        localImageView.setImageDrawable(parambcfr);
        return;
        if (bhmi.b(localFileManagerEntity.strLargeThumPath))
        {
          localObject = localFileManagerEntity.strLargeThumPath;
        }
        else
        {
          if (!bhmi.b(localFileManagerEntity.getFilePath())) {
            break label265;
          }
          localFileManagerEntity.getFilePath();
        }
      }
      label265:
      localObject = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
      if (localFileManagerEntity.getCloudType() == 1) {
        localObject = ((QQAppInterface)localObject).a().a(localFileManagerEntity, 7);
      }
    }
    for (;;)
    {
      if (TextUtils.isEmpty((CharSequence)localObject))
      {
        localImageView.setImageDrawable(BaseApplicationImpl.getContext().getResources().getDrawable(2130844316));
        return;
        if (localFileManagerEntity.getCloudType() == 2) {
          localObject = ((QQAppInterface)localObject).a().a(localFileManagerEntity.WeiYunFileId, localFileManagerEntity.strLargeThumPath, 3, localFileManagerEntity);
        }
      }
      else
      {
        localFileManagerEntity.strThumbPath = ((String)localObject);
        break;
        aunj.a(localImageView, localFileManagerEntity);
        return;
      }
      localObject = "";
    }
  }
  
  public void b(bcfr parambcfr, bcnz parambcnz)
  {
    super.b(parambcfr, parambcnz);
    if ((parambcnz.a() != null) && (!TextUtils.isEmpty(parambcfr.a())))
    {
      parambcnz.a().setVisibility(0);
      parambcnz.a().setText(parambcfr.a());
    }
    if ((parambcnz.b() != null) && (!TextUtils.isEmpty(parambcfr.b())))
    {
      parambcnz.b().setVisibility(0);
      parambcnz.b().setText(parambcfr.b());
    }
    if ((parambcnz.c() != null) && (!TextUtils.isEmpty(parambcfr.c())))
    {
      parambcnz.c().setVisibility(0);
      parambcnz.c().setText(parambcfr.c());
    }
    if ((parambcfr.d() == null) && (parambcnz.d() != null)) {
      parambcnz.d().setVisibility(8);
    }
    if ((parambcnz.d() != null) && (parambcfr.d() != null))
    {
      parambcnz.d().setVisibility(0);
      parambcnz.d().setText(parambcfr.d());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     atzy
 * JD-Core Version:    0.7.0.1
 */