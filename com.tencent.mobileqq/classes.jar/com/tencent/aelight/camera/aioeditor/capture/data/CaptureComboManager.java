package com.tencent.aelight.camera.aioeditor.capture.data;

import android.app.Activity;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.tencent.aelight.camera.aioeditor.QIMCaptureVarManager;
import com.tencent.aelight.camera.aioeditor.activity.richmedia.VideoFilterTools;
import com.tencent.aelight.camera.aioeditor.activity.richmedia.VideoFilterTools.ComboFilterData;
import com.tencent.aelight.camera.aioeditor.activity.richmedia.VideoFilterTools.DataSet;
import com.tencent.aelight.camera.aioeditor.capture.QIMManager;
import com.tencent.aelight.camera.aioeditor.capture.control.QIMAsyncManager;
import com.tencent.aelight.camera.aioeditor.capture.view.QIMCommonLoadingProgress;
import com.tencent.av.opengl.filter.qqavimage.QQAVImageFilterConstants;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.richmedia.capture.data.FilterDesc;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tribe.async.dispatch.IEventReceiver;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class CaptureComboManager
  extends QIMAsyncManager
  implements Handler.Callback, IEventReceiver
{
  public static int a = 4;
  public Handler a;
  public VideoFilterTools.ComboFilterData a;
  private ComboLockManager jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureDataComboLockManager;
  public ComboSet a;
  public FilterSet a;
  public ArrayList<QIMFilterCategoryItem> a;
  public HashMap<String, ComboSet> a;
  private boolean jdField_a_of_type_Boolean;
  public CaptureComboManager.CaptureRecord[] a;
  int b;
  public Handler b;
  public ArrayList<QIMFilterCategoryItem> b;
  public HashMap<String, FilterSet> b;
  public Handler c;
  ArrayList<CaptureComboManager.CaptureComboListener> c;
  public HashMap<String, CaptureComboFilter> c;
  public HashMap<String, ArrayList<CaptureComboManager.ComboApplyTask>> d = new HashMap();
  
  public CaptureComboManager()
  {
    this.jdField_a_of_type_JavaUtilHashMap = new HashMap();
    this.jdField_b_of_type_JavaUtilHashMap = new HashMap();
    this.jdField_c_of_type_JavaUtilHashMap = new HashMap();
    this.jdField_a_of_type_AndroidOsHandler = null;
    this.jdField_b_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper(), new CaptureComboManager.2(this));
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_b_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_c_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper(), this);
    this.jdField_c_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_a_of_type_ComTencentAelightCameraAioeditorActivityRichmediaVideoFilterTools$ComboFilterData = null;
    this.jdField_a_of_type_ArrayOfComTencentAelightCameraAioeditorCaptureDataCaptureComboManager$CaptureRecord = new CaptureComboManager.CaptureRecord[5];
    int i = 0;
    for (;;)
    {
      CaptureComboManager.CaptureRecord[] arrayOfCaptureRecord = this.jdField_a_of_type_ArrayOfComTencentAelightCameraAioeditorCaptureDataCaptureComboManager$CaptureRecord;
      if (i >= arrayOfCaptureRecord.length) {
        break;
      }
      arrayOfCaptureRecord[i] = new CaptureComboManager.CaptureRecord(i);
      i += 1;
    }
    this.jdField_b_of_type_Int = 0;
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_AndroidOsHandler = new Handler(ThreadManager.getSubThreadLooper(), new CaptureComboManager.1(this));
    this.jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureDataComboLockManager = new ComboLockManager();
  }
  
  private static boolean a(QIMFilterCategoryItem paramQIMFilterCategoryItem)
  {
    if ((paramQIMFilterCategoryItem != null) && (paramQIMFilterCategoryItem.jdField_a_of_type_JavaUtilArrayList != null))
    {
      paramQIMFilterCategoryItem = paramQIMFilterCategoryItem.jdField_a_of_type_JavaUtilArrayList.iterator();
      while (paramQIMFilterCategoryItem.hasNext()) {
        if ("EMPTY".equals((String)paramQIMFilterCategoryItem.next())) {
          return true;
        }
      }
    }
    return false;
  }
  
  public VideoFilterTools.DataSet a()
  {
    VideoFilterTools.ComboFilterData localComboFilterData = this.jdField_a_of_type_ComTencentAelightCameraAioeditorActivityRichmediaVideoFilterTools$ComboFilterData;
    if (localComboFilterData != null) {
      return localComboFilterData.a;
    }
    return null;
  }
  
  public CaptureComboFilter a(FilterDesc paramFilterDesc)
  {
    CaptureComboFilter localCaptureComboFilter2 = (CaptureComboFilter)this.jdField_c_of_type_JavaUtilHashMap.get(paramFilterDesc.name);
    CaptureComboFilter localCaptureComboFilter1 = localCaptureComboFilter2;
    if (localCaptureComboFilter2 == null)
    {
      localCaptureComboFilter1 = new CaptureComboFilter(paramFilterDesc);
      this.jdField_c_of_type_JavaUtilHashMap.put(paramFilterDesc.name, localCaptureComboFilter1);
    }
    return localCaptureComboFilter1;
  }
  
  public ComboLockManager a()
  {
    return this.jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureDataComboLockManager;
  }
  
  /* Error */
  public ComboSet a(QIMFilterCategoryItem paramQIMFilterCategoryItem)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 40	com/tencent/aelight/camera/aioeditor/capture/data/CaptureComboManager:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   4: aload_1
    //   5: getfield 161	com/tencent/aelight/camera/aioeditor/capture/data/QIMFilterCategoryItem:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   8: invokevirtual 146	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   11: checkcast 163	com/tencent/aelight/camera/aioeditor/capture/data/ComboSet
    //   14: astore 11
    //   16: aload 11
    //   18: astore 10
    //   20: aload 11
    //   22: ifnonnull +1249 -> 1271
    //   25: new 163	com/tencent/aelight/camera/aioeditor/capture/data/ComboSet
    //   28: dup
    //   29: aload_1
    //   30: invokespecial 166	com/tencent/aelight/camera/aioeditor/capture/data/ComboSet:<init>	(Ljava/lang/Object;)V
    //   33: astore 12
    //   35: aload_1
    //   36: getfield 107	com/tencent/aelight/camera/aioeditor/capture/data/QIMFilterCategoryItem:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   39: invokevirtual 111	java/util/ArrayList:iterator	()Ljava/util/Iterator;
    //   42: astore 10
    //   44: aload 10
    //   46: invokeinterface 117 1 0
    //   51: ifeq +89 -> 140
    //   54: aload 10
    //   56: invokeinterface 123 1 0
    //   61: checkcast 125	java/lang/String
    //   64: astore 11
    //   66: invokestatic 171	com/tencent/aelight/camera/aioeditor/activity/richmedia/VideoFilterTools:a	()Lcom/tencent/aelight/camera/aioeditor/activity/richmedia/VideoFilterTools;
    //   69: aload 11
    //   71: invokevirtual 174	com/tencent/aelight/camera/aioeditor/activity/richmedia/VideoFilterTools:a	(Ljava/lang/String;)Lcom/tencent/mobileqq/richmedia/capture/data/FilterDesc;
    //   74: astore 13
    //   76: aload 13
    //   78: ifnull +17 -> 95
    //   81: aload 12
    //   83: aload_0
    //   84: aload 13
    //   86: invokevirtual 176	com/tencent/aelight/camera/aioeditor/capture/data/CaptureComboManager:a	(Lcom/tencent/mobileqq/richmedia/capture/data/FilterDesc;)Lcom/tencent/aelight/camera/aioeditor/capture/data/CaptureComboFilter;
    //   89: invokevirtual 179	com/tencent/aelight/camera/aioeditor/capture/data/ComboSet:c	(Lcom/tencent/aelight/camera/aioeditor/capture/data/CaptureComboBase;)V
    //   92: goto -48 -> 44
    //   95: invokestatic 184	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   98: ifeq -54 -> 44
    //   101: new 186	java/lang/StringBuilder
    //   104: dup
    //   105: invokespecial 187	java/lang/StringBuilder:<init>	()V
    //   108: astore 13
    //   110: aload 13
    //   112: ldc 189
    //   114: invokevirtual 193	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   117: pop
    //   118: aload 13
    //   120: aload 11
    //   122: invokevirtual 193	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   125: pop
    //   126: ldc 195
    //   128: iconst_2
    //   129: aload 13
    //   131: invokevirtual 199	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   134: invokestatic 202	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   137: goto -93 -> 44
    //   140: aload_1
    //   141: getfield 205	com/tencent/aelight/camera/aioeditor/capture/data/QIMFilterCategoryItem:jdField_a_of_type_OrgJsonJSONArray	Lorg/json/JSONArray;
    //   144: astore 10
    //   146: ldc 207
    //   148: astore 11
    //   150: aload 10
    //   152: ifnull +250 -> 402
    //   155: aload_1
    //   156: getfield 205	com/tencent/aelight/camera/aioeditor/capture/data/QIMFilterCategoryItem:jdField_a_of_type_OrgJsonJSONArray	Lorg/json/JSONArray;
    //   159: invokevirtual 213	org/json/JSONArray:length	()I
    //   162: istore 8
    //   164: iconst_0
    //   165: istore 7
    //   167: iconst_0
    //   168: istore 5
    //   170: iload 5
    //   172: istore 6
    //   174: iload 7
    //   176: iload 8
    //   178: if_icmpge +227 -> 405
    //   181: aload_1
    //   182: getfield 205	com/tencent/aelight/camera/aioeditor/capture/data/QIMFilterCategoryItem:jdField_a_of_type_OrgJsonJSONArray	Lorg/json/JSONArray;
    //   185: iload 7
    //   187: invokevirtual 217	org/json/JSONArray:optJSONObject	(I)Lorg/json/JSONObject;
    //   190: astore 14
    //   192: iload 5
    //   194: istore 6
    //   196: aload 14
    //   198: ifnull +191 -> 389
    //   201: aload 14
    //   203: ldc 219
    //   205: invokevirtual 225	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   208: astore 15
    //   210: aload 14
    //   212: ldc 227
    //   214: invokevirtual 225	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   217: astore 10
    //   219: aload 14
    //   221: ldc 229
    //   223: invokevirtual 225	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   226: invokestatic 235	java/lang/Float:valueOf	(Ljava/lang/String;)Ljava/lang/Float;
    //   229: invokevirtual 239	java/lang/Float:floatValue	()F
    //   232: fstore_2
    //   233: aload 14
    //   235: ldc 241
    //   237: invokevirtual 225	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   240: invokestatic 235	java/lang/Float:valueOf	(Ljava/lang/String;)Ljava/lang/Float;
    //   243: invokevirtual 239	java/lang/Float:floatValue	()F
    //   246: fstore_3
    //   247: aload 14
    //   249: ldc 207
    //   251: invokevirtual 225	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   254: invokestatic 235	java/lang/Float:valueOf	(Ljava/lang/String;)Ljava/lang/Float;
    //   257: invokevirtual 239	java/lang/Float:floatValue	()F
    //   260: fstore 4
    //   262: new 243	com/tencent/mobileqq/richmedia/capture/data/SegmentKeeper
    //   265: dup
    //   266: invokespecial 244	com/tencent/mobileqq/richmedia/capture/data/SegmentKeeper:<init>	()V
    //   269: astore 13
    //   271: aload 13
    //   273: aload 14
    //   275: invokevirtual 248	com/tencent/mobileqq/richmedia/capture/data/SegmentKeeper:fromJSONObject	(Lorg/json/JSONObject;)V
    //   278: aload_1
    //   279: getfield 161	com/tencent/aelight/camera/aioeditor/capture/data/QIMFilterCategoryItem:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   282: aload 15
    //   284: aload 10
    //   286: fload_2
    //   287: fload_3
    //   288: fload 4
    //   290: invokestatic 253	com/tencent/aelight/camera/aioeditor/capture/paster/CaptureComboPasterFactory:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;FFF)Lcom/tencent/aelight/camera/aioeditor/capture/data/CaptureComboBase;
    //   293: astore 14
    //   295: aload 14
    //   297: ifnull +24 -> 321
    //   300: aload 14
    //   302: aload 13
    //   304: invokevirtual 258	com/tencent/aelight/camera/aioeditor/capture/data/CaptureComboBase:a	(Lcom/tencent/mobileqq/richmedia/capture/data/SegmentKeeper;)V
    //   307: aload 12
    //   309: aload 14
    //   311: invokevirtual 179	com/tencent/aelight/camera/aioeditor/capture/data/ComboSet:c	(Lcom/tencent/aelight/camera/aioeditor/capture/data/CaptureComboBase;)V
    //   314: iload 5
    //   316: istore 6
    //   318: goto +71 -> 389
    //   321: invokestatic 184	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   324: ifeq +40 -> 364
    //   327: new 186	java/lang/StringBuilder
    //   330: dup
    //   331: invokespecial 187	java/lang/StringBuilder:<init>	()V
    //   334: astore 13
    //   336: aload 13
    //   338: ldc_w 260
    //   341: invokevirtual 193	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   344: pop
    //   345: aload 13
    //   347: aload 10
    //   349: invokevirtual 193	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   352: pop
    //   353: ldc 195
    //   355: iconst_2
    //   356: aload 13
    //   358: invokevirtual 199	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   361: invokestatic 202	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   364: iconst_1
    //   365: istore 6
    //   367: goto +22 -> 389
    //   370: astore 10
    //   372: iconst_1
    //   373: istore 5
    //   375: goto +5 -> 380
    //   378: astore 10
    //   380: aload 10
    //   382: invokevirtual 263	java/lang/Exception:printStackTrace	()V
    //   385: iload 5
    //   387: istore 6
    //   389: iload 7
    //   391: iconst_1
    //   392: iadd
    //   393: istore 7
    //   395: iload 6
    //   397: istore 5
    //   399: goto -229 -> 170
    //   402: iconst_0
    //   403: istore 6
    //   405: aload_1
    //   406: getfield 265	com/tencent/aelight/camera/aioeditor/capture/data/QIMFilterCategoryItem:jdField_b_of_type_OrgJsonJSONArray	Lorg/json/JSONArray;
    //   409: ifnull +190 -> 599
    //   412: aload_1
    //   413: getfield 265	com/tencent/aelight/camera/aioeditor/capture/data/QIMFilterCategoryItem:jdField_b_of_type_OrgJsonJSONArray	Lorg/json/JSONArray;
    //   416: invokevirtual 213	org/json/JSONArray:length	()I
    //   419: istore 8
    //   421: iconst_0
    //   422: istore 7
    //   424: iload 6
    //   426: istore 5
    //   428: iload 7
    //   430: iload 8
    //   432: if_icmpge +171 -> 603
    //   435: aload_1
    //   436: getfield 265	com/tencent/aelight/camera/aioeditor/capture/data/QIMFilterCategoryItem:jdField_b_of_type_OrgJsonJSONArray	Lorg/json/JSONArray;
    //   439: iload 7
    //   441: invokevirtual 217	org/json/JSONArray:optJSONObject	(I)Lorg/json/JSONObject;
    //   444: astore 13
    //   446: iload 6
    //   448: istore 5
    //   450: aload 13
    //   452: ifnull +134 -> 586
    //   455: aload 13
    //   457: ldc_w 267
    //   460: invokevirtual 225	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   463: astore 10
    //   465: aload 13
    //   467: ldc_w 269
    //   470: invokevirtual 225	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   473: astore 13
    //   475: aload 13
    //   477: invokestatic 272	com/tencent/aelight/camera/aioeditor/capture/paster/CaptureComboPasterFactory:a	(Ljava/lang/String;)Lcom/tencent/aelight/camera/aioeditor/capture/data/CaptureComboBase;
    //   480: astore 14
    //   482: aload 14
    //   484: ifnull +17 -> 501
    //   487: aload 12
    //   489: aload 14
    //   491: invokevirtual 179	com/tencent/aelight/camera/aioeditor/capture/data/ComboSet:c	(Lcom/tencent/aelight/camera/aioeditor/capture/data/CaptureComboBase;)V
    //   494: iload 6
    //   496: istore 5
    //   498: goto +88 -> 586
    //   501: invokestatic 184	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   504: ifeq +57 -> 561
    //   507: new 186	java/lang/StringBuilder
    //   510: dup
    //   511: invokespecial 187	java/lang/StringBuilder:<init>	()V
    //   514: astore 14
    //   516: aload 14
    //   518: ldc_w 274
    //   521: invokevirtual 193	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   524: pop
    //   525: aload 14
    //   527: aload 10
    //   529: invokevirtual 193	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   532: pop
    //   533: aload 14
    //   535: ldc_w 276
    //   538: invokevirtual 193	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   541: pop
    //   542: aload 14
    //   544: aload 13
    //   546: invokevirtual 193	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   549: pop
    //   550: ldc 195
    //   552: iconst_2
    //   553: aload 14
    //   555: invokevirtual 199	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   558: invokestatic 202	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   561: iconst_1
    //   562: istore 5
    //   564: goto +22 -> 586
    //   567: astore 10
    //   569: iconst_1
    //   570: istore 5
    //   572: goto +9 -> 581
    //   575: astore 10
    //   577: iload 6
    //   579: istore 5
    //   581: aload 10
    //   583: invokevirtual 263	java/lang/Exception:printStackTrace	()V
    //   586: iload 7
    //   588: iconst_1
    //   589: iadd
    //   590: istore 7
    //   592: iload 5
    //   594: istore 6
    //   596: goto -172 -> 424
    //   599: iload 6
    //   601: istore 5
    //   603: iload 5
    //   605: istore 6
    //   607: aload_1
    //   608: getfield 278	com/tencent/aelight/camera/aioeditor/capture/data/QIMFilterCategoryItem:c	Lorg/json/JSONArray;
    //   611: ifnull +202 -> 813
    //   614: aload_1
    //   615: getfield 278	com/tencent/aelight/camera/aioeditor/capture/data/QIMFilterCategoryItem:c	Lorg/json/JSONArray;
    //   618: invokevirtual 213	org/json/JSONArray:length	()I
    //   621: istore 8
    //   623: iconst_0
    //   624: istore 7
    //   626: iload 5
    //   628: istore 6
    //   630: iload 7
    //   632: iload 8
    //   634: if_icmpge +179 -> 813
    //   637: aload_1
    //   638: getfield 278	com/tencent/aelight/camera/aioeditor/capture/data/QIMFilterCategoryItem:c	Lorg/json/JSONArray;
    //   641: iload 7
    //   643: invokevirtual 217	org/json/JSONArray:optJSONObject	(I)Lorg/json/JSONObject;
    //   646: astore 13
    //   648: iload 5
    //   650: istore 6
    //   652: aload 13
    //   654: ifnull +146 -> 800
    //   657: aload 13
    //   659: ldc_w 267
    //   662: invokevirtual 225	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   665: astore 10
    //   667: aload 13
    //   669: ldc_w 269
    //   672: invokevirtual 225	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   675: astore 13
    //   677: iload 5
    //   679: istore 6
    //   681: aload 10
    //   683: invokestatic 283	com/tencent/mobileqq/utils/StringUtil:a	(Ljava/lang/String;)Z
    //   686: ifne +114 -> 800
    //   689: aload 13
    //   691: invokestatic 285	com/tencent/aelight/camera/aioeditor/capture/paster/CaptureComboPasterFactory:b	(Ljava/lang/String;)Lcom/tencent/aelight/camera/aioeditor/capture/data/CaptureComboBase;
    //   694: astore 14
    //   696: aload 14
    //   698: ifnull +17 -> 715
    //   701: aload 12
    //   703: aload 14
    //   705: invokevirtual 179	com/tencent/aelight/camera/aioeditor/capture/data/ComboSet:c	(Lcom/tencent/aelight/camera/aioeditor/capture/data/CaptureComboBase;)V
    //   708: iload 5
    //   710: istore 6
    //   712: goto +88 -> 800
    //   715: invokestatic 184	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   718: ifeq +57 -> 775
    //   721: new 186	java/lang/StringBuilder
    //   724: dup
    //   725: invokespecial 187	java/lang/StringBuilder:<init>	()V
    //   728: astore 14
    //   730: aload 14
    //   732: ldc_w 287
    //   735: invokevirtual 193	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   738: pop
    //   739: aload 14
    //   741: aload 10
    //   743: invokevirtual 193	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   746: pop
    //   747: aload 14
    //   749: ldc_w 276
    //   752: invokevirtual 193	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   755: pop
    //   756: aload 14
    //   758: aload 13
    //   760: invokevirtual 193	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   763: pop
    //   764: ldc 195
    //   766: iconst_2
    //   767: aload 14
    //   769: invokevirtual 199	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   772: invokestatic 202	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   775: iconst_1
    //   776: istore 6
    //   778: goto +22 -> 800
    //   781: astore 10
    //   783: iconst_1
    //   784: istore 5
    //   786: goto +5 -> 791
    //   789: astore 10
    //   791: aload 10
    //   793: invokevirtual 263	java/lang/Exception:printStackTrace	()V
    //   796: iload 5
    //   798: istore 6
    //   800: iload 7
    //   802: iconst_1
    //   803: iadd
    //   804: istore 7
    //   806: iload 6
    //   808: istore 5
    //   810: goto -184 -> 626
    //   813: iload 6
    //   815: istore 5
    //   817: aload_1
    //   818: getfield 289	com/tencent/aelight/camera/aioeditor/capture/data/QIMFilterCategoryItem:d	Lorg/json/JSONArray;
    //   821: ifnull +427 -> 1248
    //   824: invokestatic 184	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   827: ifeq +64 -> 891
    //   830: new 186	java/lang/StringBuilder
    //   833: dup
    //   834: invokespecial 187	java/lang/StringBuilder:<init>	()V
    //   837: astore 10
    //   839: aload 10
    //   841: ldc_w 291
    //   844: invokevirtual 193	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   847: pop
    //   848: aload 10
    //   850: aload_1
    //   851: getfield 289	com/tencent/aelight/camera/aioeditor/capture/data/QIMFilterCategoryItem:d	Lorg/json/JSONArray;
    //   854: invokevirtual 294	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   857: pop
    //   858: aload 10
    //   860: ldc_w 296
    //   863: invokevirtual 193	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   866: pop
    //   867: aload 10
    //   869: aload_1
    //   870: getfield 289	com/tencent/aelight/camera/aioeditor/capture/data/QIMFilterCategoryItem:d	Lorg/json/JSONArray;
    //   873: invokevirtual 213	org/json/JSONArray:length	()I
    //   876: invokevirtual 299	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   879: pop
    //   880: ldc 195
    //   882: iconst_2
    //   883: aload 10
    //   885: invokevirtual 199	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   888: invokestatic 202	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   891: aload_1
    //   892: getfield 289	com/tencent/aelight/camera/aioeditor/capture/data/QIMFilterCategoryItem:d	Lorg/json/JSONArray;
    //   895: invokevirtual 213	org/json/JSONArray:length	()I
    //   898: istore 8
    //   900: iload 6
    //   902: istore 5
    //   904: iconst_0
    //   905: istore 7
    //   907: iload 8
    //   909: istore 6
    //   911: iload 7
    //   913: iload 6
    //   915: if_icmpge +333 -> 1248
    //   918: aload_1
    //   919: getfield 289	com/tencent/aelight/camera/aioeditor/capture/data/QIMFilterCategoryItem:d	Lorg/json/JSONArray;
    //   922: iload 7
    //   924: invokevirtual 217	org/json/JSONArray:optJSONObject	(I)Lorg/json/JSONObject;
    //   927: astore 13
    //   929: aload 13
    //   931: ifnull +308 -> 1239
    //   934: aload 13
    //   936: ldc_w 301
    //   939: invokevirtual 225	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   942: astore 10
    //   944: aload 13
    //   946: ldc_w 303
    //   949: invokevirtual 307	org/json/JSONObject:optJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   952: astore 15
    //   954: aload 15
    //   956: ifnull +283 -> 1239
    //   959: new 66	java/util/ArrayList
    //   962: dup
    //   963: invokespecial 67	java/util/ArrayList:<init>	()V
    //   966: astore 14
    //   968: iconst_0
    //   969: istore 8
    //   971: iload 8
    //   973: aload 15
    //   975: invokevirtual 213	org/json/JSONArray:length	()I
    //   978: if_icmpge +33 -> 1011
    //   981: aload 15
    //   983: iload 8
    //   985: invokevirtual 311	org/json/JSONArray:getString	(I)Ljava/lang/String;
    //   988: astore 16
    //   990: aload 16
    //   992: invokestatic 317	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   995: ifne +285 -> 1280
    //   998: aload 14
    //   1000: aload 16
    //   1002: invokeinterface 322 2 0
    //   1007: pop
    //   1008: goto +272 -> 1280
    //   1011: aload 13
    //   1013: ldc 229
    //   1015: invokevirtual 225	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   1018: invokestatic 235	java/lang/Float:valueOf	(Ljava/lang/String;)Ljava/lang/Float;
    //   1021: invokevirtual 239	java/lang/Float:floatValue	()F
    //   1024: fstore_2
    //   1025: aload 13
    //   1027: ldc 241
    //   1029: invokevirtual 225	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   1032: invokestatic 235	java/lang/Float:valueOf	(Ljava/lang/String;)Ljava/lang/Float;
    //   1035: invokevirtual 239	java/lang/Float:floatValue	()F
    //   1038: fstore_3
    //   1039: aload 13
    //   1041: aload 11
    //   1043: invokevirtual 225	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   1046: invokestatic 235	java/lang/Float:valueOf	(Ljava/lang/String;)Ljava/lang/Float;
    //   1049: invokevirtual 239	java/lang/Float:floatValue	()F
    //   1052: fstore 4
    //   1054: invokestatic 184	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1057: istore 9
    //   1059: iload 9
    //   1061: ifeq +233 -> 1294
    //   1064: new 186	java/lang/StringBuilder
    //   1067: dup
    //   1068: invokespecial 187	java/lang/StringBuilder:<init>	()V
    //   1071: astore 15
    //   1073: aload 15
    //   1075: ldc_w 324
    //   1078: invokevirtual 193	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1081: pop
    //   1082: aload 15
    //   1084: aload 10
    //   1086: invokevirtual 193	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1089: pop
    //   1090: ldc 195
    //   1092: iconst_2
    //   1093: aload 15
    //   1095: invokevirtual 199	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1098: invokestatic 202	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1101: goto +3 -> 1104
    //   1104: new 243	com/tencent/mobileqq/richmedia/capture/data/SegmentKeeper
    //   1107: dup
    //   1108: invokespecial 244	com/tencent/mobileqq/richmedia/capture/data/SegmentKeeper:<init>	()V
    //   1111: astore 15
    //   1113: aload 15
    //   1115: aload 13
    //   1117: invokevirtual 248	com/tencent/mobileqq/richmedia/capture/data/SegmentKeeper:fromJSONObject	(Lorg/json/JSONObject;)V
    //   1120: aload 10
    //   1122: aload 14
    //   1124: fload_2
    //   1125: fload_3
    //   1126: fload 4
    //   1128: invokestatic 327	com/tencent/aelight/camera/aioeditor/capture/paster/CaptureComboPasterFactory:a	(Ljava/lang/String;Ljava/util/List;FFF)Lcom/tencent/aelight/camera/aioeditor/capture/data/CaptureComboBase;
    //   1131: astore 13
    //   1133: aload 13
    //   1135: ifnull +20 -> 1155
    //   1138: aload 13
    //   1140: aload 15
    //   1142: invokevirtual 258	com/tencent/aelight/camera/aioeditor/capture/data/CaptureComboBase:a	(Lcom/tencent/mobileqq/richmedia/capture/data/SegmentKeeper;)V
    //   1145: aload 12
    //   1147: aload 13
    //   1149: invokevirtual 179	com/tencent/aelight/camera/aioeditor/capture/data/ComboSet:c	(Lcom/tencent/aelight/camera/aioeditor/capture/data/CaptureComboBase;)V
    //   1152: goto +87 -> 1239
    //   1155: invokestatic 184	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1158: ifeq +52 -> 1210
    //   1161: new 186	java/lang/StringBuilder
    //   1164: dup
    //   1165: invokespecial 187	java/lang/StringBuilder:<init>	()V
    //   1168: astore 13
    //   1170: aload 13
    //   1172: ldc_w 329
    //   1175: invokevirtual 193	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1178: pop
    //   1179: aload 13
    //   1181: aload 10
    //   1183: invokevirtual 193	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1186: pop
    //   1187: aload 13
    //   1189: invokevirtual 199	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1192: astore 10
    //   1194: ldc 195
    //   1196: iconst_2
    //   1197: aload 10
    //   1199: invokestatic 202	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1202: goto +8 -> 1210
    //   1205: astore 10
    //   1207: goto +11 -> 1218
    //   1210: iconst_1
    //   1211: istore 5
    //   1213: goto +26 -> 1239
    //   1216: astore 10
    //   1218: iconst_1
    //   1219: istore 5
    //   1221: goto +10 -> 1231
    //   1224: astore 10
    //   1226: goto +5 -> 1231
    //   1229: astore 10
    //   1231: aload 10
    //   1233: invokevirtual 263	java/lang/Exception:printStackTrace	()V
    //   1236: goto +3 -> 1239
    //   1239: iload 7
    //   1241: iconst_1
    //   1242: iadd
    //   1243: istore 7
    //   1245: goto -334 -> 911
    //   1248: iload 5
    //   1250: ifne +17 -> 1267
    //   1253: aload_0
    //   1254: getfield 40	com/tencent/aelight/camera/aioeditor/capture/data/CaptureComboManager:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   1257: aload_1
    //   1258: getfield 161	com/tencent/aelight/camera/aioeditor/capture/data/QIMFilterCategoryItem:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   1261: aload 12
    //   1263: invokevirtual 155	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1266: pop
    //   1267: aload 12
    //   1269: astore 10
    //   1271: aload 10
    //   1273: aload_1
    //   1274: putfield 332	com/tencent/aelight/camera/aioeditor/capture/data/ComboSet:jdField_a_of_type_JavaLangObject	Ljava/lang/Object;
    //   1277: aload 10
    //   1279: areturn
    //   1280: iload 8
    //   1282: iconst_1
    //   1283: iadd
    //   1284: istore 8
    //   1286: goto -315 -> 971
    //   1289: astore 10
    //   1291: goto -60 -> 1231
    //   1294: goto -190 -> 1104
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1297	0	this	CaptureComboManager
    //   0	1297	1	paramQIMFilterCategoryItem	QIMFilterCategoryItem
    //   232	893	2	f1	float
    //   246	880	3	f2	float
    //   260	867	4	f3	float
    //   168	1081	5	i	int
    //   172	744	6	j	int
    //   165	1079	7	k	int
    //   162	1123	8	m	int
    //   1057	3	9	bool	boolean
    //   18	330	10	localObject1	Object
    //   370	1	10	localException1	java.lang.Exception
    //   378	3	10	localException2	java.lang.Exception
    //   463	65	10	str1	String
    //   567	1	10	localException3	java.lang.Exception
    //   575	7	10	localException4	java.lang.Exception
    //   665	77	10	str2	String
    //   781	1	10	localException5	java.lang.Exception
    //   789	3	10	localException6	java.lang.Exception
    //   837	361	10	localObject2	Object
    //   1205	1	10	localException7	java.lang.Exception
    //   1216	1	10	localException8	java.lang.Exception
    //   1224	1	10	localException9	java.lang.Exception
    //   1229	3	10	localException10	java.lang.Exception
    //   1269	9	10	localObject3	Object
    //   1289	1	10	localException11	java.lang.Exception
    //   14	1028	11	localObject4	Object
    //   33	1235	12	localComboSet	ComboSet
    //   74	1114	13	localObject5	Object
    //   190	933	14	localObject6	Object
    //   208	933	15	localObject7	Object
    //   988	13	16	str3	String
    // Exception table:
    //   from	to	target	type
    //   321	364	370	java/lang/Exception
    //   201	295	378	java/lang/Exception
    //   300	314	378	java/lang/Exception
    //   501	561	567	java/lang/Exception
    //   455	482	575	java/lang/Exception
    //   487	494	575	java/lang/Exception
    //   715	775	781	java/lang/Exception
    //   657	677	789	java/lang/Exception
    //   681	696	789	java/lang/Exception
    //   701	708	789	java/lang/Exception
    //   1194	1202	1205	java/lang/Exception
    //   1155	1194	1216	java/lang/Exception
    //   1073	1101	1224	java/lang/Exception
    //   1104	1133	1224	java/lang/Exception
    //   1138	1152	1224	java/lang/Exception
    //   934	954	1229	java/lang/Exception
    //   959	968	1229	java/lang/Exception
    //   971	1008	1229	java/lang/Exception
    //   1011	1059	1229	java/lang/Exception
    //   1064	1073	1289	java/lang/Exception
  }
  
  public ComboSet a(QIMFilterCategoryItem paramQIMFilterCategoryItem, Activity paramActivity, Bundle paramBundle)
  {
    CaptureComboManager localCaptureComboManager = (CaptureComboManager)QIMManager.a(5);
    ComboSet localComboSet = localCaptureComboManager.a(paramQIMFilterCategoryItem);
    localComboSet.b(paramActivity, paramBundle.getInt("capture_scene", -1));
    localComboSet.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramActivity);
    localCaptureComboManager.a(paramQIMFilterCategoryItem);
    int i = localComboSet.jdField_a_of_type_Int;
    if (i != 1)
    {
      if (i != 2)
      {
        if (i == 3)
        {
          a(new CaptureComboManager.ComboApplyTask(localComboSet, paramBundle, paramActivity));
          paramQIMFilterCategoryItem = Message.obtain(this.jdField_c_of_type_AndroidOsHandler, 7, 0, 0, localComboSet);
          if (Looper.getMainLooper() == Looper.myLooper()) {
            a(paramQIMFilterCategoryItem);
          } else {
            paramQIMFilterCategoryItem.sendToTarget();
          }
        }
      }
      else
      {
        a(new CaptureComboManager.ComboApplyTask(localComboSet, paramBundle, paramActivity));
        localComboSet.b();
      }
    }
    else {
      a(new CaptureComboManager.ComboApplyTask(localComboSet, paramBundle, paramActivity));
    }
    if (QLog.isColorLevel())
    {
      paramQIMFilterCategoryItem = new StringBuilder();
      paramQIMFilterCategoryItem.append("applyCombo state = ");
      paramQIMFilterCategoryItem.append(localComboSet.jdField_a_of_type_Int);
      QLog.i("QCombo", 2, paramQIMFilterCategoryItem.toString());
    }
    return localComboSet;
  }
  
  public ComboSet a(String paramString)
  {
    Object localObject2 = this.jdField_a_of_type_ComTencentAelightCameraAioeditorActivityRichmediaVideoFilterTools$ComboFilterData;
    Object localObject1 = null;
    ComboSet localComboSet = null;
    if (localObject2 != null)
    {
      localObject2 = ((VideoFilterTools.ComboFilterData)localObject2).a.jdField_a_of_type_JavaUtilArrayList.iterator();
      for (;;)
      {
        localObject1 = localComboSet;
        if (!((Iterator)localObject2).hasNext()) {
          return localObject1;
        }
        localObject1 = ((FilterCategory)((Iterator)localObject2).next()).jdField_a_of_type_JavaUtilList.iterator();
        if (((Iterator)localObject1).hasNext())
        {
          QIMFilterCategoryItem localQIMFilterCategoryItem = (QIMFilterCategoryItem)((Iterator)localObject1).next();
          if (!TextUtils.equals(localQIMFilterCategoryItem.jdField_a_of_type_JavaLangString, paramString)) {
            break;
          }
          localComboSet = a(localQIMFilterCategoryItem);
        }
      }
    }
    return localObject1;
  }
  
  public FilterSet a(QIMFilterCategoryItem paramQIMFilterCategoryItem)
  {
    ArrayList localArrayList = new ArrayList();
    Object localObject1 = paramQIMFilterCategoryItem.jdField_a_of_type_JavaUtilArrayList.iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (String)((Iterator)localObject1).next();
      localObject2 = VideoFilterTools.a().a((String)localObject2);
      if (localObject2 != null) {
        localArrayList.add(localObject2);
      }
    }
    Object localObject2 = (FilterSet)this.jdField_b_of_type_JavaUtilHashMap.get(paramQIMFilterCategoryItem.jdField_a_of_type_JavaLangString);
    localObject1 = localObject2;
    if (localObject2 == null)
    {
      localObject1 = new FilterSet(paramQIMFilterCategoryItem);
      localObject2 = localArrayList.iterator();
      while (((Iterator)localObject2).hasNext()) {
        ((FilterSet)localObject1).c(a((FilterDesc)((Iterator)localObject2).next()));
      }
      this.jdField_b_of_type_JavaUtilHashMap.put(paramQIMFilterCategoryItem.jdField_a_of_type_JavaLangString, localObject1);
    }
    return localObject1;
  }
  
  public QIMFilterCategoryItem a(ComboSet paramComboSet, ArrayList<QIMFilterCategoryItem> paramArrayList)
  {
    Object localObject2 = null;
    if ((paramComboSet != null) && ((paramComboSet.jdField_a_of_type_JavaLangObject instanceof QIMFilterCategoryItem)))
    {
      Object localObject3 = (QIMFilterCategoryItem)paramComboSet.jdField_a_of_type_JavaLangObject;
      Object localObject1;
      if (((QIMFilterCategoryItem)localObject3).jdField_a_of_type_JavaUtilArrayList.isEmpty())
      {
        localObject1 = null;
      }
      else
      {
        Iterator localIterator1 = paramArrayList.iterator();
        paramComboSet = null;
        for (;;)
        {
          localObject1 = paramComboSet;
          if (!localIterator1.hasNext()) {
            break label143;
          }
          localObject1 = (QIMFilterCategoryItem)localIterator1.next();
          if (((QIMFilterCategoryItem)localObject1).jdField_a_of_type_JavaUtilArrayList.size() == ((QIMFilterCategoryItem)localObject3).jdField_a_of_type_JavaUtilArrayList.size())
          {
            Iterator localIterator2 = ((QIMFilterCategoryItem)localObject3).jdField_a_of_type_JavaUtilArrayList.iterator();
            if (localIterator2.hasNext())
            {
              String str = (String)localIterator2.next();
              if (!((QIMFilterCategoryItem)localObject1).jdField_a_of_type_JavaUtilArrayList.contains(str)) {
                break;
              }
              paramComboSet = (ComboSet)localObject1;
            }
          }
        }
      }
      label143:
      if (localObject1 == null)
      {
        localObject3 = ((QIMFilterCategoryItem)localObject3).jdField_a_of_type_JavaUtilArrayList.iterator();
        paramComboSet = (ComboSet)localObject2;
        for (;;)
        {
          localObject2 = paramComboSet;
          if (!((Iterator)localObject3).hasNext()) {
            break;
          }
          localObject2 = (String)((Iterator)localObject3).next();
          localObject2 = VideoFilterTools.a().a((String)localObject2);
          if (localObject2 != null)
          {
            if (QQAVImageFilterConstants.getFilterType(((FilterDesc)localObject2).id) == 2) {
              break;
            }
            paramComboSet = (ComboSet)localObject2;
          }
        }
        if (localObject2 != null)
        {
          paramComboSet = paramArrayList.iterator();
          while (paramComboSet.hasNext())
          {
            paramArrayList = (QIMFilterCategoryItem)paramComboSet.next();
            if ((paramArrayList.jdField_a_of_type_JavaUtilArrayList.size() == 1) && (paramArrayList.jdField_a_of_type_JavaUtilArrayList.contains(((FilterDesc)localObject2).name))) {
              return paramArrayList;
            }
          }
        }
      }
      return localObject1;
    }
    return null;
  }
  
  public void a(int paramInt)
  {
    int i = this.jdField_b_of_type_Int;
    if ((i & 0x3) == 3) {
      return;
    }
    this.jdField_b_of_type_Int = (paramInt | i);
    if ((this.jdField_b_of_type_Int & 0x3) == 3)
    {
      if (QLog.isColorLevel()) {
        QLog.i("CaptureComboManager", 2, "first random");
      }
      e();
    }
  }
  
  public void a(int paramInt, Activity paramActivity)
  {
    Object localObject = VideoFilterTools.a().a(paramInt);
    if (localObject != null)
    {
      localObject = a((QIMFilterCategoryItem)localObject);
      if ((localObject != null) && (((ComboSet)localObject).jdField_a_of_type_Int == 1))
      {
        localObject = new Bundle();
        ((Bundle)localObject).putInt("capture_scene", paramInt);
        ComboSet localComboSet = VideoFilterTools.a().a[paramInt];
        if (localComboSet != null) {
          a((QIMFilterCategoryItem)localComboSet.jdField_a_of_type_JavaLangObject, paramActivity, (Bundle)localObject);
        }
        if (QLog.isColorLevel())
        {
          paramActivity = new StringBuilder();
          paramActivity.append("stopApplyDownload scene ");
          paramActivity.append(paramInt);
          QLog.i("QCombo", 2, paramActivity.toString());
        }
      }
    }
  }
  
  public void a(Activity paramActivity)
  {
    CaptureComboManager.CaptureRecord[] arrayOfCaptureRecord = this.jdField_a_of_type_ArrayOfComTencentAelightCameraAioeditorCaptureDataCaptureComboManager$CaptureRecord;
    int j = arrayOfCaptureRecord.length;
    int i = 0;
    while (i < j)
    {
      arrayOfCaptureRecord[i].c(paramActivity);
      i += 1;
    }
  }
  
  public void a(VideoFilterTools.ComboFilterData paramComboFilterData)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("updateData data is null?");
      boolean bool;
      if (paramComboFilterData == null) {
        bool = true;
      } else {
        bool = false;
      }
      localStringBuilder.append(bool);
      QLog.d("QCombo", 2, localStringBuilder.toString());
    }
    if (paramComboFilterData != null)
    {
      this.jdField_a_of_type_ComTencentAelightCameraAioeditorActivityRichmediaVideoFilterTools$ComboFilterData = paramComboFilterData;
      this.jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureDataComboLockManager.a(paramComboFilterData);
      Message.obtain(this.jdField_c_of_type_AndroidOsHandler, 9, paramComboFilterData).sendToTarget();
    }
    a(1);
  }
  
  public void a(CaptureComboManager.CaptureComboListener paramCaptureComboListener)
  {
    synchronized (this.jdField_c_of_type_JavaUtilArrayList)
    {
      if (!this.jdField_c_of_type_JavaUtilArrayList.contains(paramCaptureComboListener)) {
        this.jdField_c_of_type_JavaUtilArrayList.add(paramCaptureComboListener);
      }
      return;
    }
  }
  
  public void a(CaptureComboManager.ComboApplyTask paramComboApplyTask)
  {
    synchronized (this.d)
    {
      String str = paramComboApplyTask.jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureDataCaptureSet.b();
      ArrayList localArrayList2 = (ArrayList)this.d.get(str);
      ArrayList localArrayList1 = localArrayList2;
      if (localArrayList2 == null)
      {
        localArrayList1 = new ArrayList();
        this.d.put(str, localArrayList1);
      }
      localArrayList1.add(paramComboApplyTask);
      return;
    }
  }
  
  public void a(CaptureSet paramCaptureSet)
  {
    if (QLog.isColorLevel())
    {
      ??? = new StringBuilder();
      ((StringBuilder)???).append("downloadComboSuccess captureSet ");
      ((StringBuilder)???).append(paramCaptureSet);
      QLog.i("QCombo", 2, ((StringBuilder)???).toString());
    }
    if ((paramCaptureSet.jdField_a_of_type_JavaLangObject instanceof QIMFilterCategoryItem)) {
      synchronized (this.jdField_b_of_type_JavaUtilArrayList)
      {
        this.jdField_b_of_type_JavaUtilArrayList.add((QIMFilterCategoryItem)paramCaptureSet.jdField_a_of_type_JavaLangObject);
        Message.obtain(this.jdField_a_of_type_AndroidOsHandler, 1, 0, 7, paramCaptureSet).sendToTarget();
        return;
      }
    }
  }
  
  public void a(CaptureSet paramCaptureSet, int paramInt)
  {
    if (QLog.isColorLevel())
    {
      ??? = new StringBuilder();
      ((StringBuilder)???).append("downloadComboFailed captureset ");
      ((StringBuilder)???).append(paramCaptureSet);
      QLog.i("QCombo", 2, ((StringBuilder)???).toString());
    }
    if ((paramCaptureSet.jdField_a_of_type_JavaLangObject instanceof QIMFilterCategoryItem)) {
      synchronized (this.jdField_b_of_type_JavaUtilArrayList)
      {
        this.jdField_b_of_type_JavaUtilArrayList.add((QIMFilterCategoryItem)paramCaptureSet.jdField_a_of_type_JavaLangObject);
        Message.obtain(this.jdField_c_of_type_AndroidOsHandler, 1, paramInt, 7, paramCaptureSet).sendToTarget();
        return;
      }
    }
  }
  
  public void a(ComboSet paramComboSet)
  {
    Iterator localIterator = this.jdField_c_of_type_JavaUtilArrayList.iterator();
    while (localIterator.hasNext()) {
      ((CaptureComboManager.CaptureComboListener)localIterator.next()).a(paramComboSet);
    }
  }
  
  public void a(QIMFilterCategoryItem paramQIMFilterCategoryItem)
  {
    SharedPreferences localSharedPreferences = BaseApplicationImpl.getApplication().getSharedPreferences("pre_capture_combo_select", 0);
    if ((!paramQIMFilterCategoryItem.e()) && (!paramQIMFilterCategoryItem.b())) {
      paramQIMFilterCategoryItem = "";
    } else {
      paramQIMFilterCategoryItem = paramQIMFilterCategoryItem.jdField_a_of_type_JavaLangString;
    }
    Object localObject = paramQIMFilterCategoryItem;
    if (paramQIMFilterCategoryItem == null) {
      localObject = "";
    }
    localSharedPreferences.edit().putString("select", (String)localObject).apply();
  }
  
  public void a(QIMFilterCategoryItem paramQIMFilterCategoryItem, Activity paramActivity, Bundle paramBundle)
  {
    int i = paramBundle.getInt("capture_scene", -1);
    QIMFilterCategoryItem localQIMFilterCategoryItem = VideoFilterTools.a().b(i);
    boolean bool1;
    if ((localQIMFilterCategoryItem != null) && (TextUtils.equals(localQIMFilterCategoryItem.jdField_a_of_type_JavaLangString, paramQIMFilterCategoryItem.jdField_a_of_type_JavaLangString))) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    boolean bool2;
    if ((localQIMFilterCategoryItem == null) && (a(paramQIMFilterCategoryItem))) {
      bool2 = true;
    } else {
      bool2 = false;
    }
    boolean bool3 = paramBundle.getBoolean("capture_force_enable", false);
    if (((bool1) || (bool2)) && (!bool3))
    {
      if (QLog.isColorLevel()) {
        QLog.d("CaptureComboManager", 2, new Object[] { "applyFilters repeat, sameItem: ", Boolean.valueOf(bool1), " emptyItem:", Boolean.valueOf(bool2), " filterItem:", paramQIMFilterCategoryItem.jdField_b_of_type_JavaLangString, " isForceEnable:", Boolean.valueOf(bool3) });
      }
      return;
    }
    paramQIMFilterCategoryItem = ((CaptureComboManager)QIMManager.a(5)).a(paramQIMFilterCategoryItem);
    paramQIMFilterCategoryItem.b(paramActivity, i);
    paramQIMFilterCategoryItem.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramActivity);
    i = paramQIMFilterCategoryItem.jdField_a_of_type_Int;
    if (i != 1)
    {
      if (i != 2)
      {
        if (i == 3)
        {
          a(new CaptureComboManager.ComboApplyTask(paramQIMFilterCategoryItem, paramBundle, paramActivity));
          paramActivity = Message.obtain(this.jdField_c_of_type_AndroidOsHandler, 7, 0, 0, paramQIMFilterCategoryItem);
          if (Looper.getMainLooper() == Looper.myLooper()) {
            a(paramActivity);
          } else {
            paramActivity.sendToTarget();
          }
        }
      }
      else
      {
        a(new CaptureComboManager.ComboApplyTask(paramQIMFilterCategoryItem, paramBundle, paramActivity));
        QIMCommonLoadingProgress.a(paramQIMFilterCategoryItem).a();
        paramQIMFilterCategoryItem.b();
      }
    }
    else {
      a(new CaptureComboManager.ComboApplyTask(paramQIMFilterCategoryItem, paramBundle, paramActivity));
    }
    if (QLog.isColorLevel())
    {
      paramActivity = new StringBuilder();
      paramActivity.append("applyFilters state = ");
      paramActivity.append(paramQIMFilterCategoryItem.jdField_a_of_type_Int);
      QLog.i("QCombo", 2, paramActivity.toString());
    }
  }
  
  public void a(boolean paramBoolean)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("yes to do setBeRecording");
      localStringBuilder.append(paramBoolean);
      QLog.i("CaptureComboManager", 2, localStringBuilder.toString());
    }
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public boolean a()
  {
    synchronized (this.jdField_b_of_type_JavaUtilArrayList)
    {
      this.jdField_a_of_type_JavaUtilArrayList.addAll(this.jdField_b_of_type_JavaUtilArrayList);
      this.jdField_b_of_type_JavaUtilArrayList.clear();
      if (QLog.isColorLevel())
      {
        ??? = new StringBuilder();
        ((StringBuilder)???).append("syncStateAndProgress ");
        ((StringBuilder)???).append(this.jdField_a_of_type_JavaUtilArrayList.size());
        QLog.i("QCombo", 2, ((StringBuilder)???).toString());
      }
      boolean bool = false;
      int i = this.jdField_a_of_type_JavaUtilArrayList.size() - 1;
      while (i >= 0)
      {
        Object localObject2 = (QIMFilterCategoryItem)this.jdField_a_of_type_JavaUtilArrayList.get(i);
        ??? = a((QIMFilterCategoryItem)localObject2);
        StringBuilder localStringBuilder;
        if (((CaptureSet)???).jdField_a_of_type_Int == 1)
        {
          int j = ((CaptureSet)???).a();
          if (j != ((CaptureSet)???).jdField_a_of_type_Int)
          {
            if (QLog.isColorLevel())
            {
              localStringBuilder = new StringBuilder();
              localStringBuilder.append("buildComboBatch progress: ");
              localStringBuilder.append(((QIMFilterCategoryItem)localObject2).jdField_b_of_type_JavaLangString);
              localStringBuilder.append(", progress: ");
              localStringBuilder.append(((CaptureSet)???).jdField_b_of_type_Int);
              QLog.d("QCombo", 2, localStringBuilder.toString());
            }
            ((CaptureSet)???).jdField_a_of_type_Int = j;
          }
          j = (int)(((CaptureSet)???).a() * 10000.0F);
          if (j != ((CaptureSet)???).jdField_b_of_type_Int)
          {
            ((CaptureSet)???).jdField_b_of_type_Int = j;
            if (QLog.isColorLevel())
            {
              localObject2 = new StringBuilder();
              ((StringBuilder)localObject2).append("buildComboBatch progress: ");
              ((StringBuilder)localObject2).append(j);
              ((StringBuilder)localObject2).append(", progress: ");
              ((StringBuilder)localObject2).append(((CaptureSet)???).jdField_b_of_type_Int);
              QLog.i("QCombo", 2, ((StringBuilder)localObject2).toString());
            }
          }
        }
        else if (((CaptureSet)???).jdField_a_of_type_Int == 2)
        {
          ((CaptureSet)???).a();
          localObject2 = (QIMFilterCategoryItem)this.jdField_a_of_type_JavaUtilArrayList.remove(i);
          if (QLog.isColorLevel())
          {
            localStringBuilder = new StringBuilder();
            localStringBuilder.append("removeComboBatch: ");
            localStringBuilder.append(((QIMFilterCategoryItem)localObject2).jdField_b_of_type_JavaLangString);
            localStringBuilder.append(",  STATE_NEED_DOWNLOAD progress: ");
            localStringBuilder.append(((CaptureSet)???).jdField_b_of_type_Int);
            QLog.i("QCombo", 2, localStringBuilder.toString());
          }
        }
        else
        {
          if (((CaptureSet)???).jdField_a_of_type_Int != 3) {
            break label525;
          }
          ((CaptureSet)???).a();
          ((CaptureSet)???).jdField_b_of_type_Int = 10000;
          localObject2 = (QIMFilterCategoryItem)this.jdField_a_of_type_JavaUtilArrayList.remove(i);
          QIMCommonLoadingProgress.a(???).b();
          Message.obtain(this.jdField_b_of_type_AndroidOsHandler, 2, ???).sendToTarget();
          if (QLog.isColorLevel())
          {
            localStringBuilder = new StringBuilder();
            localStringBuilder.append("removeComboBatch: ");
            localStringBuilder.append(((QIMFilterCategoryItem)localObject2).jdField_b_of_type_JavaLangString);
            localStringBuilder.append(", STATE_DOWNLOADED progress: ");
            localStringBuilder.append(((CaptureSet)???).jdField_b_of_type_Int);
            QLog.i("QCombo", 2, localStringBuilder.toString());
          }
        }
        bool = true;
        label525:
        i -= 1;
      }
      return bool;
    }
    for (;;)
    {
      throw localObject3;
    }
  }
  
  public boolean a(Message paramMessage)
  {
    int i = paramMessage.what;
    Object localObject1;
    if (i != 7)
    {
      if (i != 9) {
        return false;
      }
      paramMessage = (VideoFilterTools.ComboFilterData)paramMessage.obj;
      try
      {
        localObject1 = this.jdField_c_of_type_JavaUtilArrayList.iterator();
        while (((Iterator)localObject1).hasNext()) {
          ((CaptureComboManager.CaptureComboListener)((Iterator)localObject1).next()).a(paramMessage);
        }
        return false;
      }
      finally {}
    }
    i = paramMessage.arg1;
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("MSG_APPLY error ");
      ((StringBuilder)localObject1).append(i);
      ((StringBuilder)localObject1).append(" ");
      ((StringBuilder)localObject1).append(paramMessage.obj);
      QLog.d("QCombo", 2, ((StringBuilder)localObject1).toString());
    }
    Object localObject2;
    Object localObject3;
    int j;
    if ((paramMessage.obj instanceof FilterSet))
    {
      paramMessage = (FilterSet)paramMessage.obj;
      if (i == 0) {
        QIMCommonLoadingProgress.a(paramMessage).b();
      } else {
        QIMCommonLoadingProgress.a(paramMessage).c();
      }
      localObject1 = paramMessage.b();
      localObject1 = (ArrayList)this.d.get(localObject1);
      if (localObject1 != null)
      {
        localObject2 = (ArrayList)((ArrayList)localObject1).clone();
        ((ArrayList)localObject1).clear();
        localObject1 = (QIMFilterCategoryItem)paramMessage.jdField_a_of_type_JavaLangObject;
        if (i == 0)
        {
          localObject2 = ((ArrayList)localObject2).iterator();
          while (((Iterator)localObject2).hasNext())
          {
            localObject3 = (CaptureComboManager.ComboApplyTask)((Iterator)localObject2).next();
            i = ((CaptureComboManager.ComboApplyTask)localObject3).jdField_a_of_type_AndroidOsBundle.getInt("capture_scene", -1);
            ??? = VideoFilterTools.a().b(i);
            if ((localObject1 != null) && (??? != null) && (TextUtils.equals(((QIMFilterCategoryItem)localObject1).jdField_a_of_type_JavaLangString, ((QIMFilterCategoryItem)???).jdField_a_of_type_JavaLangString)) && (!this.jdField_a_of_type_Boolean))
            {
              if (QLog.isColorLevel())
              {
                ??? = new StringBuilder();
                ((StringBuilder)???).append("MSG_APPLY filter ");
                ((StringBuilder)???).append(i);
                ((StringBuilder)???).append(" ");
                ((StringBuilder)???).append(???);
                QLog.d("QCombo", 2, ((StringBuilder)???).toString());
              }
              ((QIMCaptureVarManager)QIMManager.a(13)).a(((QIMFilterCategoryItem)???).jdField_a_of_type_JavaLangString);
              ??? = (Activity)((CaptureComboManager.ComboApplyTask)localObject3).jdField_a_of_type_JavaLangRefWeakReference.get();
              if (??? != null)
              {
                paramMessage.a((Activity)???, i);
                synchronized (this.jdField_c_of_type_JavaUtilArrayList)
                {
                  ??? = this.jdField_c_of_type_JavaUtilArrayList.iterator();
                  while (((Iterator)???).hasNext()) {
                    ((CaptureComboManager.CaptureComboListener)((Iterator)???).next()).a(paramMessage, true, 0, ((CaptureComboManager.ComboApplyTask)localObject3).jdField_a_of_type_AndroidOsBundle);
                  }
                }
              }
            }
          }
          this.jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureDataFilterSet = paramMessage;
          return false;
        }
        localObject2 = ((ArrayList)localObject2).iterator();
        while (((Iterator)localObject2).hasNext())
        {
          localObject3 = (CaptureComboManager.ComboApplyTask)((Iterator)localObject2).next();
          j = ((CaptureComboManager.ComboApplyTask)localObject3).jdField_a_of_type_AndroidOsBundle.getInt("capture_scene", -1);
          ??? = VideoFilterTools.a().b(j);
          if ((localObject1 != null) && (??? != null) && (TextUtils.equals(((QIMFilterCategoryItem)localObject1).jdField_a_of_type_JavaLangString, ((QIMFilterCategoryItem)???).jdField_a_of_type_JavaLangString)))
          {
            if (QLog.isColorLevel())
            {
              ??? = new StringBuilder();
              ((StringBuilder)???).append("MSG_APPLY filter ");
              ((StringBuilder)???).append(j);
              ((StringBuilder)???).append(" ");
              ((StringBuilder)???).append(???);
              QLog.d("QCombo", 2, ((StringBuilder)???).toString());
            }
            ((QIMCaptureVarManager)QIMManager.a(13)).a(((QIMFilterCategoryItem)???).jdField_a_of_type_JavaLangString);
            if ((Activity)((CaptureComboManager.ComboApplyTask)localObject3).jdField_a_of_type_JavaLangRefWeakReference.get() != null) {
              synchronized (this.jdField_c_of_type_JavaUtilArrayList)
              {
                ??? = this.jdField_c_of_type_JavaUtilArrayList.iterator();
                while (((Iterator)???).hasNext()) {
                  ((CaptureComboManager.CaptureComboListener)((Iterator)???).next()).a(paramMessage, false, i, ((CaptureComboManager.ComboApplyTask)localObject3).jdField_a_of_type_AndroidOsBundle);
                }
              }
            }
            QQToast.a(BaseApplicationImpl.sApplication, HardCodeUtil.a(2131701567), 0).a();
          }
        }
      }
    }
    else if ((paramMessage.obj instanceof ComboSet))
    {
      paramMessage = (ComboSet)paramMessage.obj;
      if (i == 0) {
        QIMCommonLoadingProgress.a(paramMessage).b();
      } else {
        QIMCommonLoadingProgress.a(paramMessage).c();
      }
      localObject1 = (QIMFilterCategoryItem)paramMessage.jdField_a_of_type_JavaLangObject;
      localObject2 = paramMessage.b();
      localObject2 = (ArrayList)this.d.get(localObject2);
      if (localObject2 != null)
      {
        localObject3 = (ArrayList)((ArrayList)localObject2).clone();
        ((ArrayList)localObject2).clear();
        if (i == 0)
        {
          localObject2 = ((ArrayList)localObject3).iterator();
          while (((Iterator)localObject2).hasNext())
          {
            localObject3 = (CaptureComboManager.ComboApplyTask)((Iterator)localObject2).next();
            ??? = (Activity)((CaptureComboManager.ComboApplyTask)localObject3).jdField_a_of_type_JavaLangRefWeakReference.get();
            if (??? != null)
            {
              i = ((CaptureComboManager.ComboApplyTask)localObject3).jdField_a_of_type_AndroidOsBundle.getInt("capture_scene", -1);
              ??? = VideoFilterTools.a().a(i);
              if ((??? != null) && (TextUtils.equals(((QIMFilterCategoryItem)???).jdField_a_of_type_JavaLangString, ((QIMFilterCategoryItem)localObject1).jdField_a_of_type_JavaLangString)))
              {
                if (QLog.isColorLevel())
                {
                  ??? = new StringBuilder();
                  ((StringBuilder)???).append("MSG_APPLY success ");
                  ((StringBuilder)???).append(i);
                  ((StringBuilder)???).append(" ");
                  ((StringBuilder)???).append(localObject1);
                  QLog.d("QCombo", 2, ((StringBuilder)???).toString());
                }
                ((QIMCaptureVarManager)QIMManager.a(13)).b(((QIMFilterCategoryItem)localObject1).jdField_a_of_type_JavaLangString);
                if (!CaptureComboFilter.a(paramMessage, i)) {
                  paramMessage.a((Activity)???, i);
                }
                synchronized (this.jdField_c_of_type_JavaUtilArrayList)
                {
                  ??? = this.jdField_c_of_type_JavaUtilArrayList.iterator();
                  while (((Iterator)???).hasNext()) {
                    ((CaptureComboManager.CaptureComboListener)((Iterator)???).next()).a(paramMessage, true, 0, ((CaptureComboManager.ComboApplyTask)localObject3).jdField_a_of_type_AndroidOsBundle);
                  }
                }
              }
            }
          }
          this.jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureDataComboSet = paramMessage;
          return false;
        }
        localObject2 = ((ArrayList)localObject3).iterator();
        while (((Iterator)localObject2).hasNext())
        {
          localObject3 = (CaptureComboManager.ComboApplyTask)((Iterator)localObject2).next();
          j = ((CaptureComboManager.ComboApplyTask)localObject3).jdField_a_of_type_AndroidOsBundle.getInt("capture_scene", -1);
          ??? = VideoFilterTools.a().a(j);
          if ((??? != null) && (TextUtils.equals(((QIMFilterCategoryItem)???).jdField_a_of_type_JavaLangString, ((QIMFilterCategoryItem)localObject1).jdField_a_of_type_JavaLangString)))
          {
            if (QLog.isColorLevel())
            {
              ??? = new StringBuilder();
              ((StringBuilder)???).append("MSG_APPLY fail ");
              ((StringBuilder)???).append(j);
              ((StringBuilder)???).append(" ");
              ((StringBuilder)???).append(localObject1);
              QLog.d("QCombo", 2, ((StringBuilder)???).toString());
            }
            ((QIMCaptureVarManager)QIMManager.a(13)).b(((QIMFilterCategoryItem)localObject1).jdField_a_of_type_JavaLangString);
            ??? = (Activity)((CaptureComboManager.ComboApplyTask)localObject3).jdField_a_of_type_JavaLangRefWeakReference.get();
            if (??? != null) {
              synchronized (this.jdField_c_of_type_JavaUtilArrayList)
              {
                Object localObject6 = this.jdField_c_of_type_JavaUtilArrayList.iterator();
                while (((Iterator)localObject6).hasNext()) {
                  ((CaptureComboManager.CaptureComboListener)((Iterator)localObject6).next()).a(paramMessage, false, i, ((CaptureComboManager.ComboApplyTask)localObject3).jdField_a_of_type_AndroidOsBundle);
                }
                ??? = (CaptureComboManager)QIMManager.a(5);
                localObject6 = ((CaptureComboManager)???).jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureDataComboSet;
                if (localObject6 != null) {
                  ((CaptureComboManager)???).a((QIMFilterCategoryItem)((ComboSet)localObject6).jdField_a_of_type_JavaLangObject, (Activity)???, ((CaptureComboManager.ComboApplyTask)localObject3).jdField_a_of_type_AndroidOsBundle);
                }
              }
            }
            QQToast.a(BaseApplicationImpl.sApplication, HardCodeUtil.a(2131701569), 0).a();
          }
        }
      }
    }
    return false;
  }
  
  public boolean a(List<FilterCategory> paramList)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("preInitCombo: ");
      ((StringBuilder)localObject).append(paramList.size());
      QLog.d("QCombo", 2, ((StringBuilder)localObject).toString());
    }
    boolean bool1 = false;
    Object localObject = paramList.iterator();
    if (((Iterator)localObject).hasNext())
    {
      FilterCategory localFilterCategory = (FilterCategory)((Iterator)localObject).next();
      Iterator localIterator = localFilterCategory.jdField_a_of_type_JavaUtilList.iterator();
      boolean bool2 = bool1;
      for (;;)
      {
        bool1 = bool2;
        if (!localIterator.hasNext()) {
          break;
        }
        QIMFilterCategoryItem localQIMFilterCategoryItem = (QIMFilterCategoryItem)localIterator.next();
        if (localFilterCategory.jdField_a_of_type_Boolean) {
          paramList = a(localQIMFilterCategoryItem);
        } else {
          paramList = a(localQIMFilterCategoryItem);
        }
        paramList.jdField_a_of_type_Int = paramList.a();
        if (paramList.jdField_a_of_type_Int == 1)
        {
          paramList.jdField_b_of_type_Int = ((int)(paramList.a() * 10000.0F));
          if (QLog.isColorLevel())
          {
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append("preInitCombo progress: ");
            localStringBuilder.append(localQIMFilterCategoryItem.jdField_b_of_type_JavaLangString);
            localStringBuilder.append(", progress: ");
            localStringBuilder.append(paramList.jdField_b_of_type_Int);
            QLog.d("QCombo", 2, localStringBuilder.toString());
          }
          bool2 = true;
        }
        else if ((paramList.jdField_a_of_type_Int != 2) && (paramList.jdField_a_of_type_Int == 3))
        {
          paramList.jdField_b_of_type_Int = 10000;
        }
      }
    }
    return bool1;
  }
  
  public void b()
  {
    this.jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureDataComboLockManager.a();
  }
  
  public void b(CaptureComboManager.CaptureComboListener paramCaptureComboListener)
  {
    synchronized (this.jdField_c_of_type_JavaUtilArrayList)
    {
      this.jdField_c_of_type_JavaUtilArrayList.remove(paramCaptureComboListener);
      return;
    }
  }
  
  public void b(CaptureSet paramCaptureSet)
  {
    if (QLog.isColorLevel())
    {
      ??? = new StringBuilder();
      ((StringBuilder)???).append("notifyDownloadBegin combo ");
      ((StringBuilder)???).append(paramCaptureSet);
      QLog.i("QCombo", 2, ((StringBuilder)???).toString());
    }
    synchronized (this.jdField_b_of_type_JavaUtilArrayList)
    {
      this.jdField_b_of_type_JavaUtilArrayList.add((QIMFilterCategoryItem)paramCaptureSet.jdField_a_of_type_JavaLangObject);
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(1);
      return;
    }
  }
  
  public boolean b()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  public void d()
  {
    VideoFilterTools.a().a(BaseApplicationImpl.getContext(), null, false);
    if (QLog.isDevelopLevel()) {
      QLog.d("CaptureComboManager", 4, "initComboConfig");
    }
  }
  
  public void e()
  {
    VideoFilterTools.ComboFilterData localComboFilterData = this.jdField_a_of_type_ComTencentAelightCameraAioeditorActivityRichmediaVideoFilterTools$ComboFilterData;
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("randomliseData ");
      localStringBuilder.append(localComboFilterData);
      QLog.d("QCombo", 2, localStringBuilder.toString());
    }
    if (localComboFilterData != null)
    {
      localComboFilterData.a();
      a(localComboFilterData);
    }
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    return a(paramMessage);
  }
  
  public boolean isValidate()
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.capture.data.CaptureComboManager
 * JD-Core Version:    0.7.0.1
 */