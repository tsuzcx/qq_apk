package com.tencent.av.wtogether.view;

import android.content.Context;
import android.util.AttributeSet;
import atab;
import auea;
import bfif;
import bfjs;
import bfmo;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.troop.utils.TroopFileTransferManager;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import myb;
import myf;
import mzj;
import mzp;
import naq;
import nar;

public class QGroupAVFileListContentView
  extends QBaseFileListContentView
{
  private long jdField_a_of_type_Long;
  private myf jdField_a_of_type_Myf;
  private mzp jdField_a_of_type_Mzp = new nar(this);
  
  public QGroupAVFileListContentView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public QGroupAVFileListContentView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public QGroupAVFileListContentView(Context paramContext, myf parammyf, long paramLong)
  {
    super(paramContext);
    this.jdField_a_of_type_Myf = parammyf;
    this.jdField_a_of_type_Long = paramLong;
  }
  
  protected atab a()
  {
    return new myb(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, this.jdField_a_of_type_JavaUtilLinkedHashMap, this.jdField_a_of_type_Myf);
  }
  
  public String a(bfmo parambfmo)
  {
    String str = "";
    Object localObject = TroopFileTransferManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, parambfmo.jdField_a_of_type_Long);
    bfif localbfif = parambfmo.jdField_a_of_type_Bfif;
    bfjs localbfjs = ((TroopFileTransferManager)localObject).a(localbfif.jdField_b_of_type_JavaLangString);
    if (localbfjs != null) {
      str = localbfjs.jdField_b_of_type_JavaLangString;
    }
    for (;;)
    {
      localObject = str;
      if (!FileUtils.fileExistsAndNotEmpty(str)) {
        localObject = parambfmo.jdField_a_of_type_Bfif.j;
      }
      return localObject;
      ((TroopFileTransferManager)localObject).a(localbfif.jdField_b_of_type_JavaLangString, localbfif.c, localbfif.jdField_a_of_type_Int, 128);
    }
  }
  
  public void a(List<bfmo> paramList)
  {
    Collections.sort(paramList, new naq(this));
    paramList = paramList.iterator();
    label49:
    label472:
    label475:
    for (;;)
    {
      bfmo localbfmo;
      Object localObject;
      FileManagerEntity localFileManagerEntity;
      int i;
      if (paramList.hasNext())
      {
        localbfmo = (bfmo)paramList.next();
        localObject = this.jdField_a_of_type_JavaUtilList.iterator();
        if (!((Iterator)localObject).hasNext()) {
          break label472;
        }
        localFileManagerEntity = (FileManagerEntity)((Iterator)localObject).next();
        String str = localbfmo.jdField_a_of_type_Bfif.jdField_b_of_type_JavaLangString;
        if ((localFileManagerEntity.Uuid != null) && (localFileManagerEntity.Uuid.equalsIgnoreCase(str))) {
          i = 1;
        }
      }
      for (;;)
      {
        if (i != 0) {
          break label475;
        }
        localObject = new FileManagerEntity();
        ((FileManagerEntity)localObject).nSessionId = auea.a().longValue();
        ((FileManagerEntity)localObject).Uuid = localbfmo.jdField_a_of_type_Bfif.jdField_b_of_type_JavaLangString;
        ((FileManagerEntity)localObject).setCloudType(4);
        ((FileManagerEntity)localObject).fileName = localbfmo.jdField_a_of_type_Bfif.c;
        ((FileManagerEntity)localObject).fileSize = localbfmo.jdField_a_of_type_Bfif.jdField_a_of_type_Long;
        ((FileManagerEntity)localObject).nFileType = 2;
        ((FileManagerEntity)localObject).strTroopFileSha1 = localbfmo.jdField_a_of_type_Bfif.d;
        ((FileManagerEntity)localObject).busId = localbfmo.jdField_a_of_type_Bfif.jdField_a_of_type_Int;
        ((FileManagerEntity)localObject).TroopUin = localbfmo.jdField_a_of_type_Long;
        ((FileManagerEntity)localObject).strFileMd5 = localbfmo.jdField_a_of_type_Bfif.e;
        ((FileManagerEntity)localObject).peerType = 1;
        ((FileManagerEntity)localObject).peerUin = String.valueOf(localbfmo.jdField_a_of_type_Bfif.jdField_b_of_type_Long);
        ((FileManagerEntity)localObject).srvTime = (localbfmo.jdField_a_of_type_Bfif.jdField_b_of_type_Int * 1000L);
        ((FileManagerEntity)localObject).peerNick = localbfmo.jdField_b_of_type_JavaLangString;
        ((FileManagerEntity)localObject).strThumbPath = a(localbfmo);
        if (QLog.isDevelopLevel()) {
          QLog.i("QGroupAVFileListContentView", 2, "mergeTroopFileList,addEntity:fileName[" + ((FileManagerEntity)localObject).fileName + "],fileSize[" + ((FileManagerEntity)localObject).fileSize + "],Uuid[" + ((FileManagerEntity)localObject).Uuid + "],ThumbPath[" + ((FileManagerEntity)localObject).strThumbPath + "]");
        }
        ((FileManagerEntity)localObject).bOnceSuccess = true;
        a((FileManagerEntity)localObject);
        break;
        if ((Math.abs(localFileManagerEntity.srvTime - localbfmo.jdField_a_of_type_Bfif.jdField_b_of_type_Int) >= 60000L) || (localFileManagerEntity.fileSize != localbfmo.jdField_a_of_type_Bfif.jdField_a_of_type_Long) || (localFileManagerEntity.peerUin == null) || (!localFileManagerEntity.peerUin.equalsIgnoreCase(String.valueOf(localbfmo.jdField_a_of_type_Bfif.jdField_b_of_type_Long))) || (localFileManagerEntity.fileName == null) || (!localFileManagerEntity.fileName.equalsIgnoreCase(localbfmo.jdField_a_of_type_Bfif.c))) {
          break label49;
        }
        i = 1;
        continue;
        return;
        i = 0;
      }
    }
  }
  
  public void c()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Mzp);
    super.c();
  }
  
  public void d()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Mzp);
    super.d();
  }
  
  protected void e()
  {
    ((mzj)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.QAV_WT_HANDLER)).a(this.jdField_a_of_type_Long, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.av.wtogether.view.QGroupAVFileListContentView
 * JD-Core Version:    0.7.0.1
 */