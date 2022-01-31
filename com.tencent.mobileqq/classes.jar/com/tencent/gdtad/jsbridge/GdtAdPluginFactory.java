package com.tencent.gdtad.jsbridge;

import com.tencent.mobileqq.vaswebviewplugin.VasWebviewJsPlugin;
import qpj;
import qpk;
import qpl;
import qpn;
import qpo;
import qpp;
import qpq;

public class GdtAdPluginFactory
  extends VasWebviewJsPlugin
{
  private static GdtAdPluginFactory jdField_a_of_type_ComTencentGdtadJsbridgeGdtAdPluginFactory;
  GdtAdReportJsCallHandler jdField_a_of_type_ComTencentGdtadJsbridgeGdtAdReportJsCallHandler;
  GdtAppJumpJsCallHandler jdField_a_of_type_ComTencentGdtadJsbridgeGdtAppJumpJsCallHandler;
  GdtLoadAdJsCallHandler jdField_a_of_type_ComTencentGdtadJsbridgeGdtLoadAdJsCallHandler;
  GdtLocationJsCallHandler jdField_a_of_type_ComTencentGdtadJsbridgeGdtLocationJsCallHandler;
  qpj jdField_a_of_type_Qpj;
  qpk jdField_a_of_type_Qpk;
  qpl jdField_a_of_type_Qpl;
  qpn jdField_a_of_type_Qpn;
  qpo jdField_a_of_type_Qpo;
  qpp jdField_a_of_type_Qpp;
  qpq jdField_a_of_type_Qpq;
  
  public static GdtAdPluginFactory a()
  {
    if (jdField_a_of_type_ComTencentGdtadJsbridgeGdtAdPluginFactory == null) {}
    try
    {
      if (jdField_a_of_type_ComTencentGdtadJsbridgeGdtAdPluginFactory == null) {
        jdField_a_of_type_ComTencentGdtadJsbridgeGdtAdPluginFactory = new GdtAdPluginFactory();
      }
      return jdField_a_of_type_ComTencentGdtadJsbridgeGdtAdPluginFactory;
    }
    finally {}
  }
  
  public GdtJsCallHandler a(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return null;
    case 1: 
      if (this.jdField_a_of_type_ComTencentGdtadJsbridgeGdtAppJumpJsCallHandler == null) {
        this.jdField_a_of_type_ComTencentGdtadJsbridgeGdtAppJumpJsCallHandler = new GdtAppJumpJsCallHandler();
      }
      return this.jdField_a_of_type_ComTencentGdtadJsbridgeGdtAppJumpJsCallHandler;
    case 2: 
      if (this.jdField_a_of_type_Qpq == null) {
        this.jdField_a_of_type_Qpq = new qpq();
      }
      return this.jdField_a_of_type_Qpq;
    case 3: 
      if (this.jdField_a_of_type_ComTencentGdtadJsbridgeGdtAdReportJsCallHandler == null) {
        this.jdField_a_of_type_ComTencentGdtadJsbridgeGdtAdReportJsCallHandler = new GdtAdReportJsCallHandler();
      }
      return this.jdField_a_of_type_ComTencentGdtadJsbridgeGdtAdReportJsCallHandler;
    case 4: 
      if (this.jdField_a_of_type_ComTencentGdtadJsbridgeGdtLocationJsCallHandler == null) {
        this.jdField_a_of_type_ComTencentGdtadJsbridgeGdtLocationJsCallHandler = new GdtLocationJsCallHandler();
      }
      return this.jdField_a_of_type_ComTencentGdtadJsbridgeGdtLocationJsCallHandler;
    case 5: 
      if (this.jdField_a_of_type_ComTencentGdtadJsbridgeGdtLoadAdJsCallHandler == null) {
        this.jdField_a_of_type_ComTencentGdtadJsbridgeGdtLoadAdJsCallHandler = new GdtLoadAdJsCallHandler();
      }
      return this.jdField_a_of_type_ComTencentGdtadJsbridgeGdtLoadAdJsCallHandler;
    case 6: 
      if (this.jdField_a_of_type_Qpj == null) {
        this.jdField_a_of_type_Qpj = new qpj();
      }
      return this.jdField_a_of_type_Qpj;
    case 7: 
      if (this.jdField_a_of_type_Qpl == null) {
        this.jdField_a_of_type_Qpl = new qpl();
      }
      return this.jdField_a_of_type_Qpl;
    case 8: 
      if (this.jdField_a_of_type_Qpn == null) {
        this.jdField_a_of_type_Qpn = new qpn();
      }
      return this.jdField_a_of_type_Qpn;
    case 9: 
      if (this.jdField_a_of_type_Qpk == null) {
        this.jdField_a_of_type_Qpk = new qpk();
      }
      return this.jdField_a_of_type_Qpk;
    case 10: 
      if (this.jdField_a_of_type_Qpo == null) {
        this.jdField_a_of_type_Qpo = new qpo();
      }
      return this.jdField_a_of_type_Qpo;
    }
    if (this.jdField_a_of_type_Qpp == null) {
      this.jdField_a_of_type_Qpp = new qpp();
    }
    return this.jdField_a_of_type_Qpp;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.gdtad.jsbridge.GdtAdPluginFactory
 * JD-Core Version:    0.7.0.1
 */